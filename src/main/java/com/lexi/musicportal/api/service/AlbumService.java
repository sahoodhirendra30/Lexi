package com.lexi.musicportal.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lexi.musicportal.api.data.entity.Album;
import com.lexi.musicportal.api.util.AlbumPage;
import com.lexi.musicportal.api.util.SortDirection;

/**
 * Service Interface for performing operations on Artist entity
 *
 * @author Dhirendra
 *
 */

@Service
public interface AlbumService {

	Optional<AlbumPage> getAlbumsByArtist(Long artistId, int page,
			int size, String sortBy, SortDirection direction) throws Exception;

	public Album createAlbum(Long artistId, com.lexi.musicportal.api.model.Album album) throws Exception;

	public Album updateAlbum(Long artistId, Long albumId, com.lexi.musicportal.api.model.Album album) throws Exception;
	
	public Album getAlbumById(Long artistId, Long albumId) throws Exception;

}