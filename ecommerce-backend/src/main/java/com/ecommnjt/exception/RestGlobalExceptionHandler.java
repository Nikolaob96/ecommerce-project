package com.ecommnjt.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// reference: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-error-handling

public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	 	@ExceptionHandler(MultipartException.class)
	    @ResponseBody
	    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {

	        HttpStatus status = getStatus(request);
	        return new ResponseEntity<>(ex.getMessage(), status);


	    }
	 
	 private HttpStatus getStatus(HttpServletRequest request) {
		 
	        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	        
		        if (statusCode == null) {
		            return HttpStatus.INTERNAL_SERVER_ERROR;
		        }
	        return HttpStatus.valueOf(statusCode);
	    }


}
