package com.polytech.users.keaycloak.dto.user_creation;

import java.util.Collections;
import java.util.List;

public record UserCreationDto(String username, boolean enabled, List<UserCredentialsDto> credentials) {

    public static UserCreationDto of(String username, boolean enabled, String password) {
        return new UserCreationDto(username, enabled, Collections.singletonList(new UserCredentialsDto("password", password)));
    }
}
