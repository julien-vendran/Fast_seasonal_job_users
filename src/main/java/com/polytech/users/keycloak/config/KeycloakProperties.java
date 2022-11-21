package com.polytech.users.keycloak.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class KeycloakProperties {

    @Value(value = "${keycloak.realm}")
    private String realm;

    @Value(value = "${keycloak.auth-server-url}")
    private String baseUrl;

    @Value(value = "${user-microservice.keycloak.user-management.username}")
    private String adminUsername;

    @Value(value = "${user-microservice.keycloak.user-management.password}")
    private String adminPassword;

    @Value(value = "${keycloak.resource}")
    private String clientId;

    @Value(value = "${keycloak.credentials.secret}")
    private String clientSecret;
}
