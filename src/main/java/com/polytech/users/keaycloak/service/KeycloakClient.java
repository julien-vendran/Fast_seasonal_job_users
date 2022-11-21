package com.polytech.users.keaycloak.service;

import com.polytech.users.keaycloak.config.KeycloakProperties;
import com.polytech.users.keaycloak.dto.TokenDto;
import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class KeycloakClient {

    private final KeycloakProperties keycloakProperties;
    private final RestTemplate restTemplate;

    public TokenDto getToken(String grantType, String clientId, String clientSecret, String username, String password) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", grantType);
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
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
