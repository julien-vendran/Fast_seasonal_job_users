package com.polytech.users.users.controller;

import com.polytech.users.users.entity.RecruiterEntity;
import com.polytech.users.users.impl.RecruiterRepositoryImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecruiterController {

    private final RecruiterRepositoryImpl recruiterRepository;

    //Constructor
    public RecruiterController(RecruiterRepositoryImpl recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    @GetMapping("/recruiter")
    public Iterable<RecruiterEntity> findAll(){
        //TODO: handle exception with custom exceptions
        return recruiterRepository.findAll();
    }

    @GetMapping("/recruiter/{id}")
    public RecruiterEntity findById(long recruiterId){
        //TODO: handle exception with custom exceptions
        return recruiterRepository.findById(recruiterId);
    }

    @GetMapping("/recruiter/{companyName}")
    public RecruiterEntity findByCompanyName(String companyName){
        //TODO: handle exception with custom exceptions
        return recruiterRepository.findByCompanyName(companyName);
    }

    @PostMapping("/recruiter/save")
    public RecruiterEntity save(RecruiterEntity recruiterEntity){
        //TODO: handle exception with custom exceptions
        return recruiterRepository.save(recruiterEntity);
    }

    @DeleteMapping("/recruiter/delete/{id}")
    public void deleteById(Long recruiterId){
        //TODO: handle exception with custom exceptions
        recruiterRepository.deleteById(recruiterId);
    }

    @DeleteMapping("/recruiter/deleteAll")
    public void deleteAll(){
        //TODO: handle exception with custom exceptions
        recruiterRepository.deleteAll();
    }

    public boolean existsById(Long recruiterId) {
        //TODO: handle exception with custom exceptions
        return recruiterRepository.existsById(recruiterId);
    }
}
