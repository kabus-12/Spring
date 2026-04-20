package com.example.demo;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@Value("${error.insert}")
//	String msg;

	
	@ExceptionHandler(NullPointerException.class)
	public String error2() {
		return "error500";
	}
	
	@ExceptionHandler(InternalServerError.class)
	public String error1() {
		return "error500";
	}
	
	@ExceptionHandler(Exception.class)
	public String error() {
		return "error";
	}
}
