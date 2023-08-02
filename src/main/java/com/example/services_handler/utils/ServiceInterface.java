package com.example.services_handler.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface ServiceInterface {

	List<String> getServiceInput();
	ResponseEntity<Object> executeService(Map<String, Object> request);

}
