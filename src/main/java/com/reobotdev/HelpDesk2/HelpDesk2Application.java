package com.reobotdev.HelpDesk2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.reobotdev.HelpDesk2.api.entity.User;
import com.reobotdev.HelpDesk2.api.enums.ProfileEnum;
import com.reobotdev.HelpDesk2.api.repository.UserRepository;

@SpringBootApplication
public class HelpDesk2Application implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpDesk2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User( null,"a@a.com", pe.encode("12345678"), ProfileEnum.ROLE_ADMIN);
		User user2 = new User( null,"a2@a.com", pe.encode("12345678"), ProfileEnum.ROLE_ADMIN);

		userRepository.saveAll(Arrays.asList(user1,user2));
	}

}
