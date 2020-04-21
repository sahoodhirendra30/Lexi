package com.lexi.musicportal.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Images implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uri;
	private Long height;
	private Long width;
	private String resource_url;
	private String type;
	private String uri150;

}
