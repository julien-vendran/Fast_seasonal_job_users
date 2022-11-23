package com.polytech.users.recruiter.service;

import com.polytech.users.recruiter.entity.RecruiterEntity;
import com.polytech.users.recruiter.repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository recruiterRepository;

    @Override
    public RecruiterEntity save(RecruiterEntity recruiter) {
        return recruiterRepository.save(recruiter);
    }

    @Override
    public Iterable<RecruiterEntity> findAll() {
        return recruiterRepository.findAll();
    }

    @Override
    public Optional<RecruiterEntity> findById(long id) {
        return recruiterRepository.findById(id);
    }

    @Override
    public Optional<RecruiterEntity> findByCompanyName(String companyName) {
        return recruiterRepository.findByCompanyName(companyName);
    }

    @Override
    public String deleteById(long id) {
        try{
            recruiterRepository.deleteById(id);
            return "ok";
        }
        catch (Exception e){
            return null;
        }
    }
}
