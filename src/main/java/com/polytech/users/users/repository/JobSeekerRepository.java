package com.polytech.users.users.repository;

import com.polytech.users.users.entity.JobSeekerEntity;
import org.springframework.data.repository.CrudRepository;


public interface JobSeekerRepository extends CrudRepository<JobSeekerEntity, Long> {

    JobSeekerEntity findById(long id);
}
