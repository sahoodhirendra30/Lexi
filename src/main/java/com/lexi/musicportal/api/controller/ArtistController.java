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

import com.lexi.musicportal.api.model.Artist;
import com.lexi.musicportal.api.model.ArtistWrapper;
import com.lexi.musicportal.api.service.ArtistService;
import com.lexi.musicportal.api.util.ArtistPage;
import com.lexi.musicportal.api.util.SortDirection;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ArtistController extends AbstractBaseRestController {

	@Autowired
	private ArtistService artistService;

	@Autowired
	private ConversionService conversionService;

	@RequestMapping(value = "${musicportal.artist.rest.get.uri}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Get list of artists", response = Artist.class)

	public ResponseEntity<?> getAllArtists(
			@ApiParam(value = "artistName", required = true) @RequestParam(name = "artistName", required = false) String artistName,
			@ApiParam(value = "requested page number", required = false) @RequestParam(name = "page", required = false) Integer page,
			@ApiParam(value = "requested page size", required = false) @RequestParam(name = "size", required = false) Integer size,
			@ApiParam(value = "sort by column name", required = false, defaultValue = "artistId", allowableValues = "artistName") @RequestParam(name = "sort_by", required = false) String sortBy,
			@ApiParam(required = false, defaultValue = "ASC") @RequestParam(name = "sort_direction", required = false) String sortDirection)
			throws Exception {
		final List<Artist> resultList = new ArrayList<>();
		ArtistWrapper artistWrapper = null;

		try {
			SortDirection sortDirect = SortDirection.valueOf(sortDirection.toUpperCase());
			Optional<ArtistPage> result = artistService.getAllArtists(artistName, page, size, sortBy, sortDirect);

			// convert entity to model
			if (result.isPresent() && CollectionUtils.isNotEmpty(result.get().getArtistList())) {
				result.get().getArtistList()
						.forEach(artist -> resultList.add(conversionService.convert(artist, Artist.class)));
				artistWrapper = new ArtistWrapper(result.get().getMetaInfo(), resultList);
			} else {
				artistWrapper = new ArtistWrapper(null, resultList);
			}

		} catch (Exception e) {
			log.error("getAllArtists :: There was an exception in the Artist service");
			throw e;

		}
		log.debug("getAllArtists :: response={}", artistWrapper.getArtists(), artistWrapper.getMetaInfo());
		return createResponse(artistWrapper, HttpStatus.OK);

	}

	@RequestMapping(value = "${musicportal.artist.rest.get.uri}", method = RequestMethod.POST)
	public ResponseEntity<?> saveArtist(@RequestBody Artist artist) {
		try {
			artistService.createArtist(artist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "${musicportal.artist.rest.get.uri}/{artistId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateArtist(@PathVariable Long id,
			@RequestBody com.lexi.musicportal.api.model.Artist artist) {
		try {
			artistService.updateArtist(id, artist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	protected Logger getLogger() {
		return log;
	}

}
