package com.juanbastidas.appdeudas.dataSeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.juanbastidas.appdeudas.entity.Bank;
import com.juanbastidas.appdeudas.entity.User;
import com.juanbastidas.appdeudas.repository.BankRepository;
import com.juanbastidas.appdeudas.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	UserRepository userRespository;
	@Autowired
	BankRepository bankRespository;

	@Override
	public void run(String... args) throws Exception {
		loadUserData();
		loadBankData();
	}

	private void loadUserData() {
		if(userRespository.count() == 0) {
			User user1 = new User("Juan");
			User user2 = new User("Gabriel");
			userRespository.save(user1);
			userRespository.save(user2);
		}
	}
	
	private void loadBankData() {
		if(bankRespository.count() == 0) {
			Bank bank1 = new Bank("Banco 1");
			Bank bank2 = new Bank("Banco 2");
			bankRespository.save(bank1);
			bankRespository.save(bank2);
		}
	}
	
}
