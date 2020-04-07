package com.lexi.musicportal.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lexi.musicportal.api.data.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

	Page<Artist> findAll(Pageable pageable);
	
	Page<Artist> findByArtistNameContainingIgnoreCase(String artistName, Pageable pageable);

}
