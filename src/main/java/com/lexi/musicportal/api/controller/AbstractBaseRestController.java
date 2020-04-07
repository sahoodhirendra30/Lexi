package com.lexi.musicportal.api.controller;

import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;

/**
 * The Abstract base class to be sub-classed in all the Controllers. It defines common functionalities needed in all the Controllers
 *
 * @author Dhirendra
 *
 */


@Api(value = "musicportal")
public abstract class AbstractBaseRestController {

	protected abstract Logger getLogger();

	protected ResponseEntity<?> createResponse(Object obj, HttpStatus status) {
		getLogger().debug("createResponse :: creating reposnse with object and status [status={}]", status);
		return new ResponseEntity<Object>(obj, status);
	}

	protected ResponseEntity<?> createResponse(HttpStatus status) {
		getLogger().debug("createResponse :: creating reposnse with only status={}", status);
		return new ResponseEntity<Object>(status);
	}

	protected ResponseEntity<?> createResponse(HttpHeaders httpheader, HttpStatus status) {
		getLogger().debug("createResponse :: creating reposnse with httpheader and status[httpheader={}, status={}",
				httpheader, status);
		return new ResponseEntity<Object>(httpheader, status);
	}

}
