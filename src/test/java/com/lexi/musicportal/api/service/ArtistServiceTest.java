package com.lexi.musicportal.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import com.lexi.musicportal.api.exception.MusicException;
import com.lexi.musicportal.api.model.Artist;
import com.lexi.musicportal.api.repository.ArtistRepository;
import com.lexi.musicportal.api.util.ArtistPage;
import com.lexi.musicportal.api.util.SortDirection;

@RunWith(SpringRunner.class)
public class ArtistServiceTest {

	@MockBean
	ArtistRepository artistRepository;

	@InjectMocks
	private ArtistServiceImpl artistService;

	@Test
	public void testGetAllArtistsByArtistNameWithSortByArtistName() throws MusicException {

		Pageable pageRequest = PageRequest.of(1, 3, Sort.Direction.ASC, "artistName");
		try {
			when(artistRepository.findByArtistNameContainingIgnoreCase("Sahoo", pageRequest))
					.thenReturn((Page<com.lexi.musicportal.api.data.entity.Artist>) mockArtist());

		} catch (ParseException e) {
			fail("Exception occured while parsing date");
		}
		Optional<ArtistPage> artistPage = Optional.empty();
		try {
			try {
				artistPage = artistService.getAllArtists("Sahoo", 2, 3, "artistName", SortDirection.ASC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MusicException e) {
			fail("LoanServiceException occured while retrieving loans based on gridId");

		}
		assertTrue("No artist present for given name Sahoo", artistPage.isPresent());
		assertEquals("Size of list is not same as expected artist size", artistPage.get().getArtistList().size(), 2);
		assertNotNull("Page metadata is null", artistPage.get().getMetaInfo());
		assertEquals("Current page is not same as expected", artistPage.get().getMetaInfo().getCurrentPage(),
				Integer.valueOf(2));
		assertEquals("Total number of records not same as expected", artistPage.get().getMetaInfo().getTotalRecords(),
				Long.valueOf(3));
	}

	private Artist mockArtist() {
		Artist artist = new Artist();
		artist.setArtistName("Sahoo");

		return artist;

	}

}
