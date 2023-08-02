package com.example.services_handler.exception;

import java.util.Map;

public class CustomServiceException extends RuntimeException {
    private String serviceName;
    private String status;
    private String error;
    private Object completedRequest;

    public CustomServiceException(String serviceName, String status, String error, Object requestBody) {
        super("Error in " + serviceName + ": " + error);
        this.serviceName = serviceName;
        this.status = status;
        this.error = error;
        this.completedRequest = requestBody;
    }

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public Object getCompletedRequest() {
		return completedRequest;
	}
	public void setCompletedRequest(Map<String,Object> completedRequest) {
		this.completedRequest = completedRequest;
	}
    
}
