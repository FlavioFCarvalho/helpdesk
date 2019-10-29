package com.reobotdev.HelpDesk2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestRest {
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST está funcionando!";
	}

}
