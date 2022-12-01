package com.polytech.users.login;

public record LoginResponseDto(Long id, boolean isJobseeker) {

    public static LoginResponseDto ofRecruiter(Long id) {
        return new LoginResponseDto(id, false);
    }

    public static LoginResponseDto ofJobseeker(Long id) {
        return new LoginResponseDto(id, true);
    }
}
