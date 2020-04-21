package com.lexi.musicportal.api.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = ArtistDetail.TABLE)
@Data
public class ArtistDetail {

	public static final String TABLE = "ARTIST_DETAIL";

	@Id
	@SequenceGenerator(name = "ARTIST_DETAIL_SEQ", sequenceName = "ARTIST_DETAIL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTIST_DETAIL_SEQ")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 20)
	private String name;

	@Column(name = "PROFILE", nullable = false, length = 20)
	private String profile;

	@Column(name = "RELEASE_URL", nullable = false, length = 100)
	private String releases_url;

	@Column(name = "URI", nullable = false, length = 100)
	private String uri;

	@Column(name = "RESOURCE_URL", nullable = false, length = 100)
	private String resource_url;

	@Column(name = "DATA_QUALITY", nullable = false, length = 100)
	private String data_quality;

	@OneToMany(mappedBy = "artistDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Groups> groups;

	@OneToMany(mappedBy = "artistDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Images> images;

	@OneToMany(mappedBy = "artistDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<String> namevariations;

}
