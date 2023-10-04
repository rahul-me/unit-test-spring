package com.rcode.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/hello")
	public String test() {
		return "hello";
	}
}

