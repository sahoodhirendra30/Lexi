package com.lexi.musicportal.api.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lexi.musicportal.api.data.entity.Artist;
import com.lexi.musicportal.api.repository.ArtistRepository;
import com.lexi.musicportal.api.util.ArtistPage;
import com.lexi.musicportal.api.util.PageMetadata;
import com.lexi.musicportal.api.util.SortDirection;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private ConversionService conversionService;

	@Override
	public Optional<ArtistPage> getAllArtists(String artistName, int page, int size, String sortBy,
			SortDirection direction) throws Exception {
		log.debug("Invoking getAllArtists method of ArtistServiceImpl");
		ArtistPage artistPage = null;
		Page<Artist> artistList = null;
		if (direction == null) {
			direction = SortDirection.ASC;
		}

		if (null == sortBy || "".equals(sortBy)) {
			sortBy = "artistId";
		}

		Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.valueOf(direction.name()), sortBy);

		if (null == artistName) {
			artistList = artistRepository.findAll(pageable);
		} else {
			artistList = artistRepository.findByArtistNameContainingIgnoreCase(artistName, pageable);
		}

		if (null != artistList) {
			artistPage = createArtistPage(artistList);
		}
		return Optional.ofNullable(artistPage);
	}

	private ArtistPage createArtistPage(Page<Artist> artists) {
		List<Artist> artistList = artists.getContent();

		return new ArtistPage(
				new PageMetadata(Integer.valueOf(artists.getTotalPages()), Integer.valueOf(artists.getNumber() + 1),
						Long.valueOf(artists.getTotalElements()), Integer.valueOf(artists.getNumberOfElements())),
				artistList);
	}

	@Override
	public Artist createArtist(com.lexi.musicportal.api.model.Artist artist) {

		return artistRepository.save(conversionService.convert(artist, Artist.class));
	}

	@Override
	public Artist updateArtist(Long id, com.lexi.musicportal.api.model.Artist artist) {

		if (artistRepository.findById(id).isPresent()) {
			Artist existingArtist = artistRepository.findById(id).get();

			existingArtist.setArtistName(artist.getArtistName());

			Artist updatedArtist = artistRepository.save(existingArtist);

			return updatedArtist;
		} else {
			return null;
		}
	}

}