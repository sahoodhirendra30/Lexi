package com.lexi.musicportal.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lexi.musicportal.api.data.entity.Album;
import com.lexi.musicportal.api.repository.AlbumRepository;
import com.lexi.musicportal.api.util.AlbumPage;
import com.lexi.musicportal.api.util.PageMetadata;
import com.lexi.musicportal.api.util.SortDirection;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private ConversionService conversionService;

	@Override
	public Optional<AlbumPage> getAlbumsByArtist(Long artistId, int page, int size, String sortBy,
			SortDirection direction) throws Exception {
		log.debug("Invoking getAlbumsByArtist method of AlbumServiceImpl");
		AlbumPage albumPage = null;
		Page<Album> albumList = null;
		if (direction == null) {
			direction = SortDirection.ASC;
		}

		if (null == sortBy || "".equals(sortBy)) {
			sortBy = "artistId";
		}

		Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.valueOf(direction.name()), sortBy);

		albumList = albumRepository.findByArtistId(artistId, pageable);

		if (null != albumList) {
			albumPage = createAlbumPage(albumList);
		}
		return Optional.ofNullable(albumPage);
	}

	private AlbumPage createAlbumPage(Page<Album> albums) {
		List<Album> albumList = albums.getContent();

		return new AlbumPage(
				new PageMetadata(Integer.valueOf(albums.getTotalPages()), Integer.valueOf(albums.getNumber() + 1),
						Long.valueOf(albums.getTotalElements()), Integer.valueOf(albums.getNumberOfElements())),
				albumList);
	}

	@Override
	public Album createAlbum(Long artistId, com.lexi.musicportal.api.model.Album album) {
		log.info("createAlbum :: service invoked");

		return albumRepository.save(conversionService.convert(album, Album.class));
	}

	@Override
	public Album updateAlbum(Long artistId, Long albumId, com.lexi.musicportal.api.model.Album album) {
		log.info("updateAlbum :: service invoked");

		Album existingAlbum = albumRepository.findAlbumByArtistIdAndAlbumId(artistId, albumId);

		existingAlbum.setTitle(album.getTitle());
		existingAlbum.setReleaseYear(album.getReleaseYear());
		existingAlbum.setGenere(album.getGenere());
		Album updatedAlbum = albumRepository.save(existingAlbum);

		return updatedAlbum;
	}

	@Override
	public Album getAlbumById(Long artistId, Long albumId) throws Exception {
		log.info("getAlbumById :: service invoked");

		return albumRepository.findAlbumByArtistIdAndAlbumId(artistId, albumId);
	}
}
