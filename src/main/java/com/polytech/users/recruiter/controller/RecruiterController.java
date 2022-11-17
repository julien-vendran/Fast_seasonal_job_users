package com.polytech.users.recruiter.controller;

import com.polytech.users.recruiter.entity.RecruiterEntity;
import com.polytech.users.recruiter.repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/recruiter")
@RequiredArgsConstructor
public class RecruiterController {

    @Autowired
    private final RecruiterRepository recruiterRepository;

    @GetMapping()
    public Iterable<RecruiterEntity> findAll(){
        return recruiterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RecruiterEntity> findById(@PathVariable long id){
        return recruiterRepository.findById(id);
    }

    @GetMapping("/{companyName}")
    public RecruiterEntity findByCompanyName(@PathVariable String companyName){
        return recruiterRepository.findByCompanyName(companyName);
    }

    @PostMapping()
    public RecruiterEntity save(@RequestBody RecruiterEntity recruiterEntity){
        return recruiterRepository.save(recruiterEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        recruiterRepository.deleteById(id);
    }
}