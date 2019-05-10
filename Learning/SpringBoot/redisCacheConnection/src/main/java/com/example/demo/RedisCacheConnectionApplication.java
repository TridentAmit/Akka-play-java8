package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class RedisCacheConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheConnectionApplication.class, args);
	}
	
	@CacheEvict(allEntries = true, cacheNames = {"index"})
	@Scheduled(fixedRate = 100)
	public void refreshRedisCache() {
		System.out.println("Cache is got empty...");
	}
}
