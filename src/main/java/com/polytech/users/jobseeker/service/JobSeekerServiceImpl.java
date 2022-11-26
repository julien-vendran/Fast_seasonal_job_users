package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.entity.FilesEntity;
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

    @Override
    public JobSeekerEntity updateCv(Long id, FilesEntity updatedCv) {
        return findById(id).map(jobSeeker -> {
            deleteById(id);
            jobSeeker.setCv(updatedCv);
            return save(jobSeeker);
        }).orElseThrow(() -> new RuntimeException("Searched user not found")); //TODO: Changer ça
    }
}
