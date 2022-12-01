package com.polytech.users.recruiter.repository;

import com.polytech.users.recruiter.entity.Jobseeker_offerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinRepository extends CrudRepository<Jobseeker_offerEntity, Long> {}
