package com.lexi.musicportal.api.model.converter;

import org.springframework.core.convert.converter.Converter;

import com.lexi.musicportal.api.data.entity.ArtistDetail;

public class ArtistDetailModelToEntityConverter implements
		Converter<com.lexi.musicportal.api.model.ArtistDetail, com.lexi.musicportal.api.data.entity.ArtistDetail> {

	@Override
	public ArtistDetail convert(com.lexi.musicportal.api.model.ArtistDetail source) {

		ArtistDetail artistDetail = new ArtistDetail();
		artistDetail.setName(source.getName());
		artistDetail.setProfile(source.getProfile());
		artistDetail.setReleases_url(source.getReleases_url());
		artistDetail.setResource_url(source.getResource_url());
		artistDetail.setUri(source.getUri());
		artistDetail.setData_quality(source.getData_quality());
		return artistDetail;
	}

}
