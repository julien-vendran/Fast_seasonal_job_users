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
            value = "SELECT idjobseeker " +
                    "FROM offer o " +
                    "JOIN jobseekerjoinoffer jo ON o.idoffer = jo.idoffer " +
                    "WHERE o.author = :recruiter AND jo.idjobseeker = :jobseeker ; ",
            nativeQuery = true)
    Iterable<Long> hasWorkedTogether(@Param("recruiter") long recruiter,
                                     @Param("jobseeker") long jobseeker);
}
