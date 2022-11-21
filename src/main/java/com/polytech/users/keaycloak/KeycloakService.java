package com.polytech.users.keaycloak;

import com.polytech.users.keaycloak.dto.TokenDto;
import com.polytech.users.keaycloak.dto.user_creation.UserCreationDto;

public interface KeycloakService {

    TokenDto getUserToken(String username, String password);

    void createUser(UserCreationDto dto);
}
