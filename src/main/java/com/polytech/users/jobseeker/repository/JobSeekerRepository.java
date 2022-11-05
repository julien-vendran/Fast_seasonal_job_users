package com.polytech.users.jobseeker.repository;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends CrudRepository<JobSeekerEntity, Long> {
}
