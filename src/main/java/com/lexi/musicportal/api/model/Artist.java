package com.lexi.musicportal.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "artist")
@Data
@JsonPropertyOrder({"artistName"})
public class Artist implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(position = 1, value = "artistName")
	@JsonProperty("artistName")
	private String artistName;

}
