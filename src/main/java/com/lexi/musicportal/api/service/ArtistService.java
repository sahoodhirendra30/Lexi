package com.lexi.musicportal.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lexi.musicportal.api.data.entity.Artist;
import com.lexi.musicportal.api.util.ArtistPage;
import com.lexi.musicportal.api.util.SortDirection;

/**
 * Service Interface for performing operations on Artist entity
 *
 * @author Dhirendra
 *
 */

@Service
public interface ArtistService {

	Optional<ArtistPage> getAllArtists(String artistName, int page, int size, String soryBy, SortDirection direction)
			throws Exception;

	public Artist updateArtist(Long artistId, com.lexi.musicportal.api.model.Artist artist) throws Exception;

	public Artist createArtist(com.lexi.musicportal.api.model.Artist artist) throws Exception;

}