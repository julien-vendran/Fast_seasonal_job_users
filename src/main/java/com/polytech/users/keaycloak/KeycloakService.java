package com.polytech.users.keaycloak;

import com.polytech.users.keaycloak.dto.TokenDto;

public interface KeycloakService {

    TokenDto getUserToken(String username, String password);
}
