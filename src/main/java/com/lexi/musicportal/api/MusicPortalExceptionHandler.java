package com.lexi.musicportal.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class MusicPortalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
        final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.debug("handleHttpRequestMethodNotSupported :: There was an exception", ex);

        final StringBuilder message = new StringBuilder();
        message.append(ex.getMethod());
        message.append(" HTTP Request method is not supported for this request. Supported methods are:");
        ex.getSupportedHttpMethods().forEach(supportedMethod -> message.append(supportedMethod + " "));

        Error error = new Error(message.toString());
        return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
	

}
