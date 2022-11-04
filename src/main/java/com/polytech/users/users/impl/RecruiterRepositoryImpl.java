package com.polytech.users.users.impl;

import com.polytech.users.users.entity.RecruiterEntity;
import com.polytech.users.users.repository.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterRepositoryImpl implements RecruiterRepository {

    @Override
    public RecruiterEntity findById(long id) {
        return null;
    }

    @Override
    public RecruiterEntity findByCompanyName(String companyName) {
        return null;
    }

    @Override
    public RecruiterEntity save(RecruiterEntity recruiterEntity) {
        return null;
    }


    @Override
    public <S extends RecruiterEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RecruiterEntity> findById(Long recruiterId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<RecruiterEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<RecruiterEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(RecruiterEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends RecruiterEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
