package com.levo.dockerexample.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Subodh's up and running: " + new Date();
	}

}
