package com.polytech.users.keycloak.service;

import com.polytech.users.keycloak.KeycloakService;
import com.polytech.users.keycloak.config.KeycloakProperties;
import com.polytech.users.keycloak.config.KeycloakUserManagementInformation;
import com.polytech.users.keycloak.dto.TokenDto;
import com.polytech.users.keycloak.dto.user_creation.UserCreationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {
    private final RestTemplate restTemplate;
    private final KeycloakProperties keycloakProperties;
    private final KeycloakClient keycloakClient;
    private final KeycloakUserManagementInformation userManagementInformation;

    private static final String GRANT_TYPE = "password";

    @Override
    public TokenDto getUserToken(String username, String password) {
        return keycloakClient.getToken(GRANT_TYPE, keycloakProperties.getClientId(), keycloakProperties.getClientSecret(), username, password);
    }

    @Override
    public void createUser(UserCreationDto dto) {
        Map<String, Object> body = Map.of(
            "username", dto.username(),
            "enabled", dto.enabled(),
            "credentials", dto.credentials()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(userManagementInformation.getAdminToken());

        var httpEntity = new HttpEntity<>(body, headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(keycloakProperties.getBaseUrl())
            .pathSegment("admin", "realms", keycloakProperties.getRealm(), "users")
            .build();

        restTemplate.exchange(builder.toUriString(), HttpMethod.POST, httpEntity, String.class);
    }
}
