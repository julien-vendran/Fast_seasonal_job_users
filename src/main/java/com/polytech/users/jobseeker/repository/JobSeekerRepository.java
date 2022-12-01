package com.polytech.users.jobseeker.repository;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeekerRepository extends CrudRepository<JobSeekerEntity, Long> {

    @Query(
        value = "SELECT id " +
            "FROM jobseeker j " +
            "WHERE j.email = :email ; ",
        nativeQuery = true)
    Optional<Long> findByEmail(@Param("email") String email);

}
