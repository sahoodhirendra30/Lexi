package com.lexi.musicportal.api.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = Images.TABLE)
@Data
public class Images {

	public static final String TABLE = "IMAGES";

	@Id
	@SequenceGenerator(name = "IMAGES_SEQ", sequenceName = "IMAGES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGES_SEQ")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "URI", nullable = true, length = 100)
	private String uri;
	
	@Column(name = "HEIGHT", nullable = true, length = 6)
	private Long height;
	
	@Column(name = "WIDTH", nullable = true, length = 6)
	private Long width;
	
	@Column(name = "RESOURCE_URL", nullable = true, length = 100)
	private String resource_url;
	
	@Column(name = "TYPE", nullable = true, length = 20)
	private String type;
	
	@Column(name = "URI150", nullable = true, length = 100)
	private String uri150;

}
