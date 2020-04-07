package com.lexi.musicportal.api.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lexi.musicportal.api.model.Album;
import com.lexi.musicportal.api.model.Artist;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AlbumEntityToModelConverter
		implements Converter<com.lexi.musicportal.api.data.entity.Album, com.lexi.musicportal.api.model.Album> {

	@Override
	public Album convert(com.lexi.musicportal.api.data.entity.Album source) {
		log.debug("convert **************************:: album entity={}", source);
		com.lexi.musicportal.api.model.Album target = new com.lexi.musicportal.api.model.Album();
		target.setArtistId(source.getArtistId());		
		target.setTitle(source.getTitle());
		target.setReleaseYear(source.getReleaseYear());
		target.setGenere(source.getGenere());

		return target;

	}

}
