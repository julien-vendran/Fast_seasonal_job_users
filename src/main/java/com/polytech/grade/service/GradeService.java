package com.polytech.grade.service;

import com.polytech.grade.entity.GradeEntity;

import java.util.Optional;

public interface GradeService {
    GradeEntity save(GradeEntity grade);

    Iterable<GradeEntity> findAll();

    Optional<GradeEntity> findById(long id);

    void deleteById(long id);

    Optional<GradeEntity> findByMark(float mark);
}
