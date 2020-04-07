package com.lexi.musicportal.api.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lexi.musicportal.api.data.entity.Artist;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ArtistModelToEntityConverter
		implements Converter<com.lexi.musicportal.api.model.Artist, com.lexi.musicportal.api.data.entity.Artist> {

	@Override
	public Artist convert(com.lexi.musicportal.api.model.Artist source) {
		log.debug("convert **************************:: artist model={}", source);
		Artist target = new Artist();		
		target.setArtistName(source.getArtistName());
		return target;

	}

}
