package com.example.services_handler.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.services_handler.exception.CustomServiceException;
import com.example.services_handler.service.Service1;
import com.example.services_handler.service.Service2;
import com.example.services_handler.service.Service3;
import com.example.services_handler.service.Service4;
import com.example.services_handler.utils.HashMapConverter;
import com.example.services_handler.utils.ServiceInterface;

@Component
public class ServiceClient {

	@Autowired
	private Service1 service1;

	@Autowired
	private Service2 service2;

	@Autowired
	private Service3 service3;

	@Autowired
	private Service4 service4;

	List<ServiceInterface> listOfSerivces = new ArrayList<>();

	@PostConstruct
	public void init() {
		listOfSerivces.add(service1);
		listOfSerivces.add(service2);
		listOfSerivces.add(service3);
		listOfSerivces.add(service4);
	}

	public ResponseEntity<Object> executeService() {
		try {

			Map<String, Object> req = new HashMap<>();
			req.put("serviceName", "1");
			req.put("id", "10");
			
			ResponseEntity<Object> response = new ResponseEntity<Object>(req, HttpStatus.OK);

			for (ServiceInterface service : listOfSerivces) {
				String requestBody = HashMapConverter.convertMapToString(HashMapConverter.convertObjectToMap(response.getBody()));
				List<String> requestParams = service.getServiceInput();
				Map<String, Object> request = convertToRequest(requestParams, requestBody);
				response = service.executeService(request);
				System.out.println(response.getBody());

			}
			return response;
		} catch (CustomServiceException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Map<String, Object> convertToRequest(List<String> paramsName, String body) {
		Map<String, Object> request = new HashMap<>();
		Map<String, Object> r = HashMapConverter.convertToStringToMap(body);
		paramsName.forEach(p -> request.put(p,  r.get(p)));
		return request;
	}

}
