package com.polytech.users.keaycloak.config;

import com.polytech.users.keaycloak.dto.TokenDto;
import com.polytech.users.keaycloak.service.KeycloakClient;
import org.springframework.stereotype.Component;

@Component
public class KeycloakUserManagementInformation {

    private final String adminToken;
    private static final String GRANT_TYPE = "password";

    public KeycloakUserManagementInformation(KeycloakProperties keycloakProperties, KeycloakClient keycloakClient) {
        TokenDto tokens = keycloakClient.getToken(GRANT_TYPE, "admin-rest-client", null, keycloakProperties.getAdminUsername(), keycloakProperties.getAdminPassword());
        adminToken = tokens.access_token();
    }

    public String getAdminToken() {
        return adminToken;
    }
}
