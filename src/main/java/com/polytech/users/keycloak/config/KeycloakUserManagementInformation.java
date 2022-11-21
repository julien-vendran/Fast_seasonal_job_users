package com.polytech.users.keycloak.config;

import com.polytech.users.keycloak.dto.TokenDto;
import com.polytech.users.keycloak.service.KeycloakClient;
import org.springframework.stereotype.Component;

@Component
public class KeycloakUserManagementInformation {

    private final String adminToken;
    private static final String GRANT_TYPE = "password";

    public KeycloakUserManagementInformation(KeycloakProperties keycloakProperties, KeycloakClient keycloakClient) {
        TokenDto tokens = keycloakClient.getToken(GRANT_TYPE, keycloakProperties.getClientId(), keycloakProperties.getClientSecret(), keycloakProperties.getAdminUsername(), keycloakProperties.getAdminPassword());
        adminToken = tokens.access_token();
    }

    public String getAdminToken() {
        return adminToken;
    }
}
