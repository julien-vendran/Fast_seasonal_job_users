package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/jobseeker")
@RequiredArgsConstructor
@Slf4j
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    @PostMapping
    JobSeekerEntity save(@RequestBody JobSeekerEntity jobSeeker) {
        return jobSeekerService.save(jobSeeker);
    }

    @GetMapping()
    Iterable<JobSeekerEntity> findAll() {
        return jobSeekerService.findAll();
    }

    @GetMapping("/{id}")
    Optional<JobSeekerEntity> findById(@PathVariable long id) {
        return jobSeekerService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id) {
        jobSeekerService.deleteById(id);
    }
}
