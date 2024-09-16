package com.example.SpringBootLearning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadPropertiesController {
	
	//use default value if properties is not found and print as "default value"
	@Value("${my.greeting:default value}")
	private String greetingMessage;
	
	//to get list from properties file
	@Value("${my.list.values}")
	List<String> listValues;
	
	//SpEL (#{}) is used for complex data structure like map
	@Value("#{${map.Dbvalues}}")
    Map<String, String> dbValues;
	
	//Getting values from ConfigurationProperties when you have multiple properties
	@Autowired
	DbSettings dbSetting;
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage;
	}
	
	@GetMapping("/getListValues")
	public List<String> getListValues() {
		return listValues;
	}
	
	@GetMapping("/getMapValues")
	public Map<String, String> getMapValues() {
		return dbValues;
	}
	
	@GetMapping("/getDbValues")
	public String getDbValues() {
		return dbSetting.getName() + " " + dbSetting.getPassword();
	}

}
