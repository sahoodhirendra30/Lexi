package com.lexi.musicportal.api.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lexi.musicportal.api.data.entity.Images;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ImagesModelToEntityConverter implements
		Converter<com.lexi.musicportal.api.model.ArtistDetail, List<com.lexi.musicportal.api.data.entity.Images>> {

	@Override
	public List<Images> convert(com.lexi.musicportal.api.model.ArtistDetail source) {

		List<Images> imagesList = new ArrayList<Images>();

		if (CollectionUtils.isNotEmpty(source.getImages())) {
			source.getImages().parallelStream().forEach(response -> {
				Images images = new Images();
				images.setUri(response.getUri());
				images.setResource_url(response.getResource_url());
				images.setType(response.getType());
				images.setWidth(response.getWidth());
				images.setHeight(response.getHeight());
				images.setUri150(response.getUri150());
				imagesList.add(images);
			});
		}
		log.debug("convert :: target Images={}", imagesList);
		return imagesList;

	}

}
