package com.example.services_handler.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.services_handler.config.Config;
import com.example.services_handler.exception.CustomServiceException;
import com.example.services_handler.utils.HashMapConverter;
import com.example.services_handler.utils.ServiceInterface;
import com.example.services_handler.utils.ServiceRequestStatus;

@Service
public class Service3 implements ServiceInterface {
	
	@Autowired
	private Config config;
	
	@Override
	public List<String> getServiceInput() {
		return config.getParameterNameList(this.getClass().getSimpleName());
	}

	@Override
	public ResponseEntity<Object> executeService(Map<String, Object> request) {
		try {
			Map<String, Object> response = new HashMap<>();
			response.put("id", request.get("id"));
			response.put("Services", request.get("Services"));
			response.put("status", ServiceRequestStatus.COMPLETED.toString());
			response.put("account", "FaceBook");
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new CustomServiceException("Service3", "failed", e.getMessage(), request);
		}
	}

}
