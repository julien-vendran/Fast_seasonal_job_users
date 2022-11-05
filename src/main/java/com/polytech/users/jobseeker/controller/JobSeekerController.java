package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobseeker")
@RequiredArgsConstructor
public class JobSeekerController {
    private final JobSeekerRepository jobSeekerRepository;

    @PostMapping()
    JobSeekerEntity create(JobSeekerEntity jobSeekerEntity) {
        return jobSeekerRepository.save(jobSeekerEntity);
    }

    @GetMapping()
    Iterable<JobSeekerEntity> getAll() {
        return jobSeekerRepository.findAll();
    }
}
