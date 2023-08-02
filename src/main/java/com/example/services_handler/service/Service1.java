package com.example.services_handler.service;

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
public class Service1 implements ServiceInterface {

	@Autowired
	private Config config;

	@Override
	public ResponseEntity<Object> executeService(Map<String, Object> request) {
		try {
			request.put("status", ServiceRequestStatus.COMPLETED.toString());
			request.put("name", "user");
			return new ResponseEntity<Object>(request, HttpStatus.OK);
		} catch (Exception e) {
			throw new CustomServiceException("Service1", "failed", e.getMessage(), request);
		}
	}

	@Override
	public List<String> getServiceInput() {
		return config.getParameterNameList(this.getClass().getSimpleName());
	}

}
