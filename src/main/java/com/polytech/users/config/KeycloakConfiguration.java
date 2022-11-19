package com.polytech.users.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {
    /**
     * By Default, the Spring Security Adapter looks for a keycloak.json configuration file.
     * You can make sure it looks at the configuration provided by the Spring Boot Adapter by adding this bean
     * @return
     */
    @Bean
    public KeycloakConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}