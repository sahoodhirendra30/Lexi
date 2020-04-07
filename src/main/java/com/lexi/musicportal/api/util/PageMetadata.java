package com.lexi.musicportal.api.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PageMetadata {

	@ApiModelProperty(position = 3, required = true, example = "3")
	private Integer totalPages;

	@ApiModelProperty(position = 1, required = true, example = "1")
	private Integer currentPage;

	@ApiModelProperty(position = 4, required = true, example = "30")
	private Long totalRecords;

	@ApiModelProperty(position = 2, required = true, example = "10")
	private Integer noOfRecordsCurrentPage;

}
