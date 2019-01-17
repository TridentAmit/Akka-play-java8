package com.example.boot.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    
    @GetMapping("/hellos")
    public String index() {
    	System.out.println("this is being called............");
        return "Greetings from Spring Boot!!!!!";
    }
    @GetMapping("/calling")
    public String apiCalling() {
    	RestTemplate restTemplate = new RestTemplate();
    	URI uri = null;
		try {
			uri = new URI("http://gturnquist-quoters.cfapps.io/api/random");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
    	String string = restTemplate.getForObject(uri, String.class);
    	Stream.iterate(0, i->i+1).limit(10).forEach((i)->System.out.println("==============="+string +i));
    	return string;
    }
    
}
