package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobSeekerServiceImpl implements JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;

    @Override
    public JobSeekerEntity save(JobSeekerEntity jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
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
}
