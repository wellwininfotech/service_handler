package com.example.services_handler.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class HashMapConverter {
	
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String convertMapToString(Map<String, Object> req) {

		String payloadToJson = null;
		try {
			payloadToJson = objectMapper.writeValueAsString(req);
		} catch (final JsonProcessingException e) {
		}

		return payloadToJson;
	}

	public static Map<String, Object> convertToStringToMap(String payloadJson) {

		Map<String, Object> payload = null;
		try {
			payload = objectMapper.readValue(payloadJson, Map.class);
		} catch (final IOException e) {

		}
		return payload;
	}
	
	public static Map<String, Object> convertObjectToMap(Object object) {
        Map<String, Object> result = new HashMap();
        if (object == null) {
            return result;
        }
        
        result = objectMapper.convertValue(object, new TypeReference<Map<String,Object>>() {
		});
        
        return result;
    }

}
