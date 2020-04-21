package com.lexi.musicportal.api.util;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.lexi.musicportal.api.model.ArtistDetail;

public class ClientForArtistDetail {	
	
	public ArtistDetail artistDetailClient(Long id) throws Exception {
		final String uri = "https://api.discogs.com/artists/"+id;
		HttpHeaders headers = new HttpHeaders();
		RequestEntity<Long> requestEntity;

		ResponseEntity<ArtistDetail> respEntity = null;
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);

			SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(uri));
			respEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ArtistDetail>() {
			});
		} catch (Exception e) {
		}

		return respEntity.getBody();
	}

}
