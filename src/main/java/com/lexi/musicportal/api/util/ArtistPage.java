package com.lexi.musicportal.api.util;

import java.util.List;

import com.lexi.musicportal.api.data.entity.Artist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtistPage {

	private PageMetadata metaInfo;

	private List<Artist> artistList;

}
