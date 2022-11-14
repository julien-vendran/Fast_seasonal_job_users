package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/jobseeker")
@RequiredArgsConstructor
public class JobSeekerController {
    private final JobSeekerRepository jobSeekerRepository;

    @PostMapping()
    JobSeekerEntity save(JobSeekerEntity jobSeekerEntity) {
        return jobSeekerRepository.save(jobSeekerEntity);
    }

    @GetMapping()
    Iterable<JobSeekerEntity> findAll() {
        return jobSeekerRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<JobSeekerEntity> findById(@PathVariable long id) {
        return jobSeekerRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id) {
        jobSeekerRepository.deleteById(id);
    }
}
