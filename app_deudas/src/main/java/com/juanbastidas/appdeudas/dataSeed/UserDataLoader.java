package com.juanbastidas.appdeudas.dataSeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.juanbastidas.appdeudas.entity.User;
import com.juanbastidas.appdeudas.repository.UserRepository;

@Component
public class UserDataLoader implements CommandLineRunner {

	@Autowired
	UserRepository userRespository;

	@Override
	public void run(String... args) throws Exception {
		loadUserData();
	}

	private void loadUserData() {
		if(userRespository.count() == 0) {
			User user1 = new User("Juan", true);
			User user2 = new User("Gabriel", true);
			
			userRespository.save(user1);
			userRespository.save(user2);
		}
	}
	
	
	
}
