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
@Table(name = Artist.TABLE)
@Data
public class Artist {

	public static final String TABLE = "ARTIST";

	@Id
	@SequenceGenerator(name = "ARTIST_SEQ", sequenceName = "ARTIST_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTIST_SEQ")
	@Column(name = "ARTIST_ID")
	private Long artistId;

	@Column(name = "ARTIST_NAME", nullable = false, length = 20)
	private String artistName;

	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Album> album;

}
