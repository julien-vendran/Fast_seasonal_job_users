package com.polytech.users.keycloak.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenDto(String access_token, int expires_in, int refresh_expires_in, String refresh_token,
                       String token_type, @JsonProperty("not-before-policy") int notBeforePolicy,
                       @JsonProperty("session_state") String sessionState, String scope) {
}