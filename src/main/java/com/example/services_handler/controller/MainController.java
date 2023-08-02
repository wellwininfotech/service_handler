package com.example.services_handler.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services_handler.client.ServiceClient;

@RestController
public class MainController {

	@Autowired
	private ServiceClient client;
	
	@GetMapping("/main")
	public ResponseEntity<Object> getRequest2() {
		return client.executeService();
	}
}
