package com.polytech.users.recruiter.service;

import com.polytech.users.recruiter.entity.RecruiterEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface RecruiterService {
    RecruiterEntity save(RecruiterEntity recruiter);
    Iterable<RecruiterEntity> findAll();
    Optional<RecruiterEntity> findById(long id);
    Iterable<RecruiterEntity> findByCompanyName(String companyName);
    ResponseEntity<String> deleteById(long id);
}
