package com.testing.controller.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.testing.controller.service.ServiceCheck;

@RestController
public class MainController {
	
	@Autowired
	ServiceCheck service;
	
	private static final Logger  logger=LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/{number:\\d+}")
	public Long getNumber(@PathVariable Long number) {
		logger.info("This is number");
		
		return number;
	}
	@GetMapping("/{charecters:[a-z]+}")
	public String getString(@PathVariable String charecters) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map=new HashMap<>();
		map.put("abc", "getName");
		map.put("def", "getLocation");
		String name=map.get(charecters);
		Method checking=ServiceCheck.class.getMethod(name,null);
		return (String) checking.invoke(service,null);
	}
}
