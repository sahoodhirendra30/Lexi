package com.lexi.musicportal.api.util;

import java.util.List;

import com.lexi.musicportal.api.data.entity.Album;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlbumPage {

	private PageMetadata metaInfo;

	private List<Album> albumList;

}
