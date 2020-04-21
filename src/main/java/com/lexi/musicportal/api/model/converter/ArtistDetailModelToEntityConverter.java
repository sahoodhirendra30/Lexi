package com.lexi.musicportal.api.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lexi.musicportal.api.data.entity.ArtistDetail;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ArtistDetailModelToEntityConverter implements
		Converter<com.lexi.musicportal.api.model.ArtistDetail, com.lexi.musicportal.api.data.entity.ArtistDetail> {

	@Override
	public ArtistDetail convert(com.lexi.musicportal.api.model.ArtistDetail source) {

		ArtistDetail artistDetail = new ArtistDetail();

		artistDetail.setArtDetId(source.getId());
		artistDetail.setName(source.getName());
		artistDetail.setProfile(source.getProfile());
		artistDetail.setReleases_url(source.getReleases_url());
		artistDetail.setResource_url(source.getResource_url());
		artistDetail.setUri(source.getUri());
		artistDetail.setData_quality(source.getData_quality());
		artistDetail.setChad(source.getNamevariations().getChad());
		artistDetail.setChanning(source.getNamevariations().getChanning());

		log.debug("convert :: target ArtistDetail={}", artistDetail);

		return artistDetail;
	}

}
