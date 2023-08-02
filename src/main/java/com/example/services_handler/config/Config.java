package com.example.services_handler.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Config {

	private Map<String, Object> request;

	private static Map<String, List<String>> config = new HashMap<>();

	@Autowired
	private ObjectMapper mapper;

	@PostConstruct
	public void getConfig() {
		try {
			ResourceLoader resourceLoader = new DefaultResourceLoader();
			Resource resource = resourceLoader.getResource("classpath:request_config.json");
			config = mapper.readValue(resource.getFile(), Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getParameterNameList(String serviceName){
		return config.get(serviceName);
	}

}
