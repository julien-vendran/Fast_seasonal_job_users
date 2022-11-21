package com.polytech.users.keycloak;

import com.polytech.users.keycloak.dto.TokenDto;
import com.polytech.users.keycloak.dto.user_creation.UserCreationDto;

public interface KeycloakService {

    TokenDto getUserToken(String username, String password);

    void createUser(UserCreationDto dto);
}
