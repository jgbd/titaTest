package com.juanbastidas.appdeudas.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanbastidas.appdeudas.entity.Debt;
import com.juanbastidas.appdeudas.service.DebtService;

@RestController
@RequestMapping("/api/debts")
public class DebtController {
	@Autowired
	private DebtService debtService;
	@PutMapping("/{id}")
	public ResponseEntity<?> pagarDeuda(@RequestBody Debt debt, @PathVariable Long id) {
		Optional<Debt> debtUpdate = debtService.findById(id);
		if(!debtUpdate.isPresent()) return ResponseEntity.notFound().build();
		Debt d = debtUpdate.get();
		if(debt.getCuotas() < 1 || debt.getValor() > d.getValor() || debt.getCuotas() > d.getCuotas() || 
				(debt.getCuotas() == d.getCuotas() && debt.getValor() < d.getValor() ) ) {
			Map<String, String> res = new HashMap<>();
			res.put("Error", "Error en la peticion");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		d.setCuotas(d.getCuotas()-debt.getCuotas());
		d.setValor(d.getValor()-debt.getValor());
		debtService.save(d);
		return ResponseEntity.ok(d);
	}
}
