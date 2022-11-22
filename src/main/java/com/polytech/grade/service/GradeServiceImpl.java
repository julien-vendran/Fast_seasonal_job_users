package com.polytech.grade.service;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GradeServiceImpl implements GradeService{

    public final GradeRepository gradeRepository;

    @Override
    public GradeEntity save(GradeEntity grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Iterable<GradeEntity> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<GradeEntity> findById(long id) {
        return gradeRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Optional<GradeEntity> findByMark(float mark) {
        return gradeRepository.findByMark(mark);
    }
}
