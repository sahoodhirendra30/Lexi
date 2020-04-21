package com.lexi.musicportal.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Groups implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private boolean active;
	private String resource_url;

}
