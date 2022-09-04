/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanbastidas.appdeudas.entity.Bank;
import com.juanbastidas.appdeudas.entity.User;
import com.juanbastidas.appdeudas.response.DebtResponse;
import com.juanbastidas.appdeudas.response.UserBankDebt;
import com.juanbastidas.appdeudas.service.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {

	@Autowired
	private UserService userService;

	// Read user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
		Optional<UserBankDebt> oUser = userService.getBankAndDebtById(userId);
		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Map<String, Object> res =  formatteResponse(oUser.get());
		return ResponseEntity.ok(res);
	}

	@GetMapping
	public List<User> readAll() {
		List<User> users = StreamSupport.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}

	private Map<String,Object> formatteResponse(UserBankDebt response) {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> banks = new ArrayList<>();
		map.put("idUser", response.getUser().getId());
		map.put("nameUser", response.getUser().getName());
		for(int i = 0; i< response.getLstBanks().size(); i++ ) {
			Bank b = response.getLstBanks().get(i);
			Map<String, Object> bank = new HashMap<>();
			bank.put("idBank", b.getId());
			bank.put("nameBank", b.getName());
			List<DebtResponse> debts = new ArrayList<>();
			for(int j = 0; j< response.getLstDebts().size(); j++ ) {
				List<DebtResponse> lde = response.getLstDebts().get(j);
				for(int k =0;k<lde.size();k++) {
					DebtResponse d = lde.get(k);
					if(d.getIdBank() == b.getId()) {
						debts.add(d);
					}
				}
			}
			bank.put("debts", debts);
			banks.add(bank);
		}
		map.put("banks", banks);
		return map;
	}
}
