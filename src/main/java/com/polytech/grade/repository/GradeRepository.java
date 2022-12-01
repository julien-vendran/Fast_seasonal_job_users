package com.polytech.grade.repository;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.entity.GradeId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends CrudRepository<GradeEntity, GradeId> {
    Iterable<GradeEntity> findByMark(int mark);
    Iterable<GradeEntity> findByRecruiter(long recruiter);
    Iterable<GradeEntity> findByJobseeker(long jobseeker);

    @Query(
            value = "SELECT jobseeker_id " +
                    "FROM offer o " +
                    "JOIN jobseeker_offer jo ON o.id = jo.offer_id " +
                    "WHERE o.author = :recruiter AND jo.jobseeker_id = :jobseeker ; ",
            nativeQuery = true)
    Iterable<Long> hasWorkedTogether(@Param("recruiter") long recruiter,
                                     @Param("jobseeker") long jobseeker);
}
