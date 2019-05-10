package com.example.demo.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisCacheController {

	@Cacheable(value = "index", key = "#id")
	@GetMapping("/redis/connector/{id}")
    public String index(@PathVariable int id) {
    	switch(id) {
    	case 1: 
    		System.out.println("One is requested");
    		return "one";
    	case 2:
    		System.out.println("Two is requested");
    		return "two";
    	 default:
    		 System.out.println("Not found was called:"+id);
    		return "Not found";
    	}
    }
	
}
