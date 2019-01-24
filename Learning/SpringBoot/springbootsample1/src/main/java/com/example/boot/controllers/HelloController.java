package com.example.boot.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.boot.model.Customer;
import com.example.boot.mongo.dao.CustomerRepository;

@RestController
public class HelloController {
	
	@Autowired
	private CustomerRepository repository;
    
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
    
    @GetMapping("/mongoDB")
    public String mongoDbCalling() {
    	repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		return "done";
    }
    
}
