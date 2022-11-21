package com.polytech.users.jobseeker.dto;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.keaycloak.dto.user_creation.UserCreationDto;

public record JobSeekerCreationDto(JobSeekerEntity jobSeeker, String password) {

    public UserCreationDto toUserCreationDto() {
        return UserCreationDto.of(jobSeeker().getEmail(), true, password);
    }
}
