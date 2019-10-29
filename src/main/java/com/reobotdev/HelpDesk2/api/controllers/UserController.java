package com.reobotdev.HelpDesk2.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.reobotdev.HelpDesk2.api.entity.User;
import com.reobotdev.HelpDesk2.api.service.UserService;



@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins = "*")
public class UserController{
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		User obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}