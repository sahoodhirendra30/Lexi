package com.lexi.musicportal.api.model;

import java.util.List;

import com.lexi.musicportal.api.util.PageMetadata;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

@Data
@Value
public class ArtistWrapper {

	@ApiModelProperty(position = 1, required = true)
	private PageMetadata metaInfo;
	@ApiModelProperty(position = 1, required = true)
	private List<Artist> artists;

}
