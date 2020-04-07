package com.lexi.musicportal.api.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lexi.musicportal.api.model.Artist;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ArtistEntityToModelConverter
		implements Converter<com.lexi.musicportal.api.data.entity.Artist, com.lexi.musicportal.api.model.Artist> {

	@Override
	public Artist convert(com.lexi.musicportal.api.data.entity.Artist source) {
		log.debug("convert **************************:: artist entity={}", source);
		com.lexi.musicportal.api.model.Artist target = new com.lexi.musicportal.api.model.Artist();
		target.setArtistName(source.getArtistName());
		return target;

	}

}
