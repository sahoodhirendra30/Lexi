package com.lexi.musicportal.api.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = Album.TABLE)
@Data
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TABLE = "ALBUM";

	@Id
	@SequenceGenerator(name = "ALBUM_SEQ", sequenceName = "ALBUM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUM_SEQ")
	@Column(name = "ALBUM_ID")
	private Long albumId;

	@Column(name = "ARTIST_ID", nullable = false, length = 20)
	private Long artistId;

	@Column(name = "TITLE", nullable = false, length = 20)
	private String title;

	@Column(name = "RELEASE_YEAR", nullable = false, length = 20)
	private String releaseYear;

	@Column(name = "GENRE", nullable = false, length = 20)
	private String genere;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ARTIST_ID", referencedColumnName = "ARTIST_ID", insertable = false, updatable = false)
	private Artist artist;

}
