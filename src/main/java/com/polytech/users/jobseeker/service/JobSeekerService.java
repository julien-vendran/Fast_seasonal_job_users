package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.entity.FilesEntity;
import com.polytech.users.jobseeker.entity.JobSeekerEntity;

import java.util.Optional;

public interface JobSeekerService {
    JobSeekerEntity save(JobSeekerEntity jobSeeker);

    Iterable<JobSeekerEntity> findAll();

    Optional<JobSeekerEntity> findById(long id);

    void deleteById(long id);

    JobSeekerEntity updateCv(Long id, FilesEntity updatedCv);

    void applyOffer(Long userId, Long offerId);
}
