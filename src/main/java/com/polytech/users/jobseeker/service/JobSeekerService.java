package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;

import java.util.Optional;

public interface JobSeekerService {
    JobSeekerEntity save(JobSeekerEntity jobSeeker);

    Iterable<JobSeekerEntity> findAll();

    Optional<JobSeekerEntity> findById(long id);

    void deleteById(long id);
}