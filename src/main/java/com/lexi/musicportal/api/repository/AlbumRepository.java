package com.lexi.musicportal.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lexi.musicportal.api.data.entity.Album;
import com.lexi.musicportal.api.data.entity.Artist;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

	Page<Album> findAll(Pageable pageable);
	
	Page<Album> findByArtistId(Long artistId, Pageable pageable);
	
	Album findAlbumByArtistIdAndAlbumId(Long artistId, Long albumId);

}
