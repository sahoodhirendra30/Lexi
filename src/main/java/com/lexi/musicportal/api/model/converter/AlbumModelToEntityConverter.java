package com.lexi.musicportal.api.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lexi.musicportal.api.data.entity.Album;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AlbumModelToEntityConverter
		implements Converter<com.lexi.musicportal.api.model.Album, com.lexi.musicportal.api.data.entity.Album> {

	@Override
	public Album convert(com.lexi.musicportal.api.model.Album source) {
		log.debug("convert **************************:: album model={}", source);
		Album target = new Album();
		target.setArtistId(source.getArtistId());
		target.setTitle(source.getTitle());
		target.setReleaseYear(source.getReleaseYear());
		target.setGenere(source.getGenere());

		return target;

	}

}
