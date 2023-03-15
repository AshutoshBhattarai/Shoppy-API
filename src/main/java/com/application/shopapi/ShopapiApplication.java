package com.application.shopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
public class ShopapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopapiApplication.class, args);
	}

	@GetMapping("/")
	public String appHome()
	{
		return "Welcome to the app home page";
	}

}
