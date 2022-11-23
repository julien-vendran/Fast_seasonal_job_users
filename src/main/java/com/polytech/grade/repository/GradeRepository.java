package com.polytech.grade.repository;

import com.polytech.grade.entity.GradeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends CrudRepository<GradeEntity, Long> {
    Optional<GradeEntity> findByMark(float mark);
    Iterable<GradeEntity> findByRecruiter(long id);
    Iterable<GradeEntity> findByJobseeker(long id);

}
