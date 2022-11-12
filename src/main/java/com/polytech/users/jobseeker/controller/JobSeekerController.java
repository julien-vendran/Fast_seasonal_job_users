package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    Optional<JobSeekerEntity> getById(@PathVariable String id) {
        return jobSeekerRepository.findById(Long.getLong(id));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        Long idL = Long.getLong(id);
        jobSeekerRepository.deleteById(idL);
    }
}
