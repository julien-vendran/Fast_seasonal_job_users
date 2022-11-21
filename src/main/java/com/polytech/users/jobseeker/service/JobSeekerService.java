package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.dto.JobSeekerCreationDto;
import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface JobSeekerService {
    JobSeekerEntity save(JobSeekerCreationDto jobSeekerCreationDto);

    Iterable<JobSeekerEntity> findAll();

    Optional<JobSeekerEntity> findById(long id);

    void deleteById(long id);

    ResponseEntity<String> generateToken(String username, String password);
}
