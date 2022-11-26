package com.polytech.users.recruiter.service;

import com.polytech.users.recruiter.entity.RecruiterEntity;
import com.polytech.users.recruiter.repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public Iterable<RecruiterEntity> findByCompanyName(String companyName) {
        return recruiterRepository.findByCompanyName(companyName);
    }

    @Override
    public ResponseEntity<String> deleteById(long id) {
        try {
            recruiterRepository.deleteById(id);
            return ResponseEntity.ok("Delete recruiter completed.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
