package com.reobotdev.HelpDesk2.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reobotdev.HelpDesk2.api.entity.User;
import com.reobotdev.HelpDesk2.api.enums.ProfileEnum;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@RequestMapping(method =RequestMethod.GET)
	public List<User> listar() {

		User user = new User(null, "a@a.com", "12345678", ProfileEnum.ROLE_ADMIN);
		User user2 = new User(null, "a@3a.com", "12345678", ProfileEnum.ROLE_ADMIN);

		List<User> lista = new ArrayList<>();
		lista.add(user);
		lista.add(user2);

		return lista;
	}

}
