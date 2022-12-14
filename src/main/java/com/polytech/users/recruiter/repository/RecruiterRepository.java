package com.polytech.users.recruiter.repository;


import com.polytech.users.recruiter.entity.RecruiterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends CrudRepository<RecruiterEntity, Long> {
    Iterable<RecruiterEntity> findByCompanyName(String companyName);
    Optional<RecruiterEntity> findByEmail(String email);
}
