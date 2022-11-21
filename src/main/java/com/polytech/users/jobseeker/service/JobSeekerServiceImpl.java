package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.dto.JobSeekerCreationDto;
import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.repository.JobSeekerRepository;
import com.polytech.users.keycloak.KeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobSeekerServiceImpl implements JobSeekerService {

    private final KeycloakService keycloakService;
    private final JobSeekerRepository jobSeekerRepository;

    @Override
    public JobSeekerEntity save(JobSeekerCreationDto jobSeekerCreationDto) {
        keycloakService.createUser(jobSeekerCreationDto.toUserCreationDto());
        return jobSeekerRepository.save(jobSeekerCreationDto.jobSeeker());
    }

    @Override
    public Iterable<JobSeekerEntity> findAll() {
        return jobSeekerRepository.findAll();
    }

    @Override
    public Optional<JobSeekerEntity> findById(long id) {
        return jobSeekerRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        jobSeekerRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<String> generateToken(String username, String password) {
        try {
            var tokenDto = keycloakService.getUserToken(username, password);
            return ResponseEntity.ok(tokenDto.access_token());
        } catch (Exception e) { //todo: Mieux gérer les différentes exceptions
            log.error("Error occured while generating a token", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
