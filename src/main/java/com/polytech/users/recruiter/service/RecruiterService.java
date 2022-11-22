package com.polytech.users.recruiter.service;

import com.polytech.users.recruiter.entity.RecruiterEntity;

import java.util.Optional;


public interface RecruiterService {
    RecruiterEntity save(RecruiterEntity recruiter);
    Iterable<RecruiterEntity> findAll();
    Optional<RecruiterEntity> findById(long id);

    Optional<RecruiterEntity> findByCompanyName(String companyName);
    void deleteById(long id);
}
