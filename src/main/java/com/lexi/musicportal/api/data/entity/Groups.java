package com.lexi.musicportal.api.data.entity;

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
@Table(name = Groups.TABLE)
@Data
public class Groups {

	public static final String TABLE = "GROUPS";

	@Id
	@SequenceGenerator(name = "GROUPS_SEQ", sequenceName = "GROUPS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUPS_SEQ")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 20)
	private String name;
	
	@Column(name = "ACTIVE", nullable = false, length = 6)
	private Boolean active;
	
	@Column(name = "RESOURCE_URL", nullable = false, length = 100)
	private String resource_url;

	@ManyToOne
    @JoinColumn(name = "ID", insertable = false, updatable = false, referencedColumnName = "ID")     
    private ArtistDetail artistDetail;


}
