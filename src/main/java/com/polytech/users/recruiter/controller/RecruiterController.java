package com.polytech.users.recruiter.controller;

import com.polytech.users.recruiter.entity.RecruiterEntity;
import com.polytech.users.recruiter.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recruiter")
@RequiredArgsConstructor
public class RecruiterController {

    private final RecruiterService recruiterService;

    @PostMapping
    RecruiterEntity save(@RequestBody RecruiterEntity recruiter) {
        return recruiterService.save(recruiter);
    }

    @GetMapping
    Iterable<RecruiterEntity> findAll() {
        return recruiterService.findAll();
    }

    @GetMapping("/{id}")
    Optional<RecruiterEntity> findById(@PathVariable long id) {
        return recruiterService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        recruiterService.deleteById(id);
    }

    @GetMapping("/{companyName}")
    Optional<RecruiterEntity> findByCompanyName(@PathVariable String companyName) {
        return recruiterService.findByCompanyName(companyName);
    }
}
