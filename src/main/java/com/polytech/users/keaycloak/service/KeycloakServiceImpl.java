package com.polytech.users.keaycloak.service;

import com.polytech.users.keaycloak.KeycloakService;
import com.polytech.users.keaycloak.config.KeycloakProperties;
import com.polytech.users.keaycloak.dto.TokenDto;
import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {
    private final RestTemplate restTemplate;
    private final KeycloakProperties keycloakProperties;

    private static final String GRANT_TYPE = "password";

    @Override
    public TokenDto getUserToken(String username, String password) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", GRANT_TYPE);
        body.add("client_id", keycloakProperties.getClientId());
        body.add("client_secret", keycloakProperties.getClientSecret());
        body.add("username", username);
        body.add("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        var httpEntity = new HttpEntity<>(body, headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(keycloakProperties.getBaseUrl())
            .pathSegment("realms", keycloakProperties.getRealm(), "protocol", "openid-connect", "token")
            .build();

        ResponseEntity<TokenDto> result = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, httpEntity, TokenDto.class);
        if (result.getBody() == null) {
            throw new InternalException();
        }
        return result.getBody();
    }
}
