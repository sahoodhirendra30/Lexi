package com.lexi.musicportal.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lexi.musicportal.api.model.Album;
import com.lexi.musicportal.api.model.AlbumWrapper;
import com.lexi.musicportal.api.service.AlbumService;
import com.lexi.musicportal.api.util.AlbumPage;
import com.lexi.musicportal.api.util.SortDirection;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AlbumController extends AbstractBaseRestController {

	@Autowired
	private AlbumService albumService;

	@Autowired
	private ConversionService conversionService;

	@RequestMapping(value = "${musicportal.artist.rest.get.uri}/{artistId}/albums", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> getAlbumsByArtist(
			@ApiParam(value = "artistId", required = true) @RequestParam(name = "artistId", required = true) Long artistId,
			@ApiParam(value = "requested page number", required = false) @RequestParam(name = "page", required = false) Integer page,
			@ApiParam(value = "requested page size", required = false) @RequestParam(name = "size", required = false) Integer size,
			@ApiParam(value = "sort by column name", required = false, defaultValue = "albumId", allowableValues = "title,releaseYear") @RequestParam(name = "sort_by", required = false) String sortBy,
			@ApiParam(required = false, defaultValue = "ASC") @RequestParam(name = "sort_direction", required = true) String sortDirection)
			throws Exception {

		 log.info("getAlbumsByArtist :: controller invoked");

		final List<Album> resultList = new ArrayList<>();
		AlbumWrapper albumWrapper = null;

		try {
			SortDirection sortDirect = SortDirection.valueOf(sortDirection.toUpperCase());
			Optional<AlbumPage> result = albumService.getAlbumsByArtist(artistId, page, size, sortBy, sortDirect);

			// convert entity to model
			if (result.isPresent() && CollectionUtils.isNotEmpty(result.get().getAlbumList())) {
				result.get().getAlbumList()
						.forEach(album -> resultList.add(conversionService.convert(album, Album.class)));
				albumWrapper = new AlbumWrapper(result.get().getMetaInfo(), resultList);
			} else {
				albumWrapper = new AlbumWrapper(null, resultList);
			}

		} catch (Exception e) {
			log.error("getAlbumsByArtist :: There was an exception in the Artist service");
			throw e;

		}
		log.debug("getAlbumsByArtist :: response={}", albumWrapper.getAlbum(), albumWrapper.getMetaInfo());
		return createResponse(albumWrapper, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/${musicportal.artist.rest.get.uri}/{artistId}/albums/{albumId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAlbum(@PathVariable Long artistId, @PathVariable Long albumId, @RequestBody com.lexi.musicportal.api.model.Album album) {
		 log.info("updateAlbum :: controller invoked");
		try {
			albumService.updateAlbum(artistId, albumId, album);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/${musicportal.artist.rest.get.uri}/{artistId}/albums", method = RequestMethod.POST)
	public ResponseEntity<?> saveAlbum(@PathVariable Long artistId, @RequestBody com.lexi.musicportal.api.model.Album album) {
		 log.info("saveAlbum :: controller invoked");
		try {
			albumService.createAlbum(artistId, album);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value = "/${musicportal.artist.rest.get.uri}/{artistId}/albums/{albumId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAlbumById(@PathVariable Long artistId, @PathVariable Long albumId) {
		log.info("getAlbumById :: controller invoked");
		try {
			albumService.getAlbumById(artistId, albumId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	protected Logger getLogger() {
		return log;
	}
}