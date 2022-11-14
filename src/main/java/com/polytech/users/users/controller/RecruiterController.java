package com.polytech.users.users.controller;

import com.polytech.users.users.entity.RecruiterEntity;
import com.polytech.users.users.repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/recruiter")
@RequiredArgsConstructor
public class RecruiterController {

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

    @PostMapping("/save")
    public RecruiterEntity create(@RequestBody RecruiterEntity recruiterEntity){
        return recruiterRepository.save(recruiterEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        recruiterRepository.deleteById(id);
    }

}
