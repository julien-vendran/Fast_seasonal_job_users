package com.polytech.users.users.repository;


import com.polytech.users.users.entity.RecruiterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends CrudRepository<RecruiterEntity, Long> {
    public RecruiterEntity findByCompanyName(String companyName);
}
