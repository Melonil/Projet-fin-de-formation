package com.m2i.java.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Data
@SuperBuilder
public class Response {
	protected LocalDateTime timeStamp;
	protected int statusCode;
	protected HttpStatus status;
	protected String reason;
	protected String message;
	protected String developerMessage;
	protected Map<?,?> data;
	
	
	public Response(LocalDateTime timeStamp, int statusCode, HttpStatus status, String reason, String message,
		String developerMessage, Map<?, ?> data) {
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.status = status;
		this.reason = reason;
		this.message = message;
		this.developerMessage = developerMessage;
		this.data = data;
	}
	

}


