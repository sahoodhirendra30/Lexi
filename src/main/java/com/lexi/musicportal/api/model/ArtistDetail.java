package com.lexi.musicportal.api.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ArtistDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String profile;
	private String releases_url;
	private String uri;
	private String resource_url;
	private String data_quality;
	private List<Groups> groups;;
	private List<Images> images;
	private Namevariations namevariations;

	@Data
	public class Namevariations {

		private String Chad;
		private String Channing;
	}
}
