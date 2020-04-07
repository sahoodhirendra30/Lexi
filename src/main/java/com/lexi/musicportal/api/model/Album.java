package com.lexi.musicportal.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "album")
@Data
@JsonPropertyOrder({ "artistId", "title", "name", "releaseYear", "genere" })
public class Album {

	@ApiModelProperty(position = 1, value = "artistId")
	@JsonProperty("artistId")
	private Long artistId;

	@ApiModelProperty(position = 2, value = "title")
	@JsonProperty("title")
	private String title;

	@ApiModelProperty(position = 3, value = "releaseYear")
	@JsonProperty("releaseYear")
	private String releaseYear;

	@ApiModelProperty(position = 4, value = "genere")
	@JsonProperty("genere")
	private String genere;

}
