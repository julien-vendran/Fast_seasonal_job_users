package com.polytech.grade.service;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.entity.GradeId;
import org.springframework.http.ResponseEntity;


import java.util.Optional;

public interface GradeService {
    ResponseEntity<GradeEntity> save(GradeEntity grade) throws NullPointerException;

    Iterable<GradeEntity> findAll();

    Optional<GradeEntity> findById(GradeId idGrade);

    ResponseEntity<String> deleteById(GradeId idGrade);

    Iterable<GradeEntity> findByMark(int mark);

    Iterable<GradeEntity> findByRecruiter(long recruiter);

    Iterable<GradeEntity> findByJobseeker(long jobseeker);
}
