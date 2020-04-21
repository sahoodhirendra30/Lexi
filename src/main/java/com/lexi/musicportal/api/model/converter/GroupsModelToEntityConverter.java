package com.lexi.musicportal.api.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lexi.musicportal.api.data.entity.Groups;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GroupsModelToEntityConverter implements
		Converter<com.lexi.musicportal.api.model.ArtistDetail, List<com.lexi.musicportal.api.data.entity.Groups>> {

	@Override
	public List<Groups> convert(com.lexi.musicportal.api.model.ArtistDetail source) {

		List<Groups> groupsList = new ArrayList<Groups>();

		if (CollectionUtils.isNotEmpty(source.getGroups())) {
			source.getGroups().parallelStream().forEach(response -> {
				Groups groups = new Groups();
				groups.setGroupId(response.getId());
				groups.setName(response.getName());
				groups.setResource_url(response.getResource_url());
				groups.setActive(response.isActive());
				groupsList.add(groups);
			});
		}
		log.debug("convert :: target Groups={}", groupsList);
		return groupsList;

	}

}
