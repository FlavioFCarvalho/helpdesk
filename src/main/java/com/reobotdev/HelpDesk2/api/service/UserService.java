package com.reobotdev.HelpDesk2.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reobotdev.HelpDesk2.api.entity.User;
import com.reobotdev.HelpDesk2.api.repository.UserRepository;

@Service
public class UserService {
   
	@Autowired
	private UserRepository userRepository;
	
	public User buscar(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElse(null);
	}
	
}
