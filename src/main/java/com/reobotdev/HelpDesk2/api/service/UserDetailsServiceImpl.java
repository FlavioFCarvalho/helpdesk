package com.reobotdev.HelpDesk2.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reobotdev.HelpDesk2.api.entity.User;
import com.reobotdev.HelpDesk2.api.repository.UserRepository;
import com.reobotdev.HelpDesk2.api.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if (user  == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(user.getId(), user.getEmail(), user.getPassword(), user.getPerfis());
	}
}
