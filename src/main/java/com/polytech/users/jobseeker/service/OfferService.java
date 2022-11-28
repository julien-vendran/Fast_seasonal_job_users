package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.entity.OfferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequiredArgsConstructor
public class OfferService {

    private final static URI GATEWAY_URI = URI.create("http://localhost:8085");

    private final RestTemplate restTemplate;

    public OfferEntity getById(Long id) {
        String uri = UriComponentsBuilder
            .fromUri(GATEWAY_URI)
            .path("api/offer/" + id)
            .build().toUriString();
        return restTemplate.getForObject(uri, OfferEntity.class);
    }

    public void save(OfferEntity offer) {
        String uri = UriComponentsBuilder
            .fromUri(GATEWAY_URI)
            .path("api/offer")
            .build().toUriString();
        restTemplate.postForObject(uri, offer, Void.class);
    }
}
