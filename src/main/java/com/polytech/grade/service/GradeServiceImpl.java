package com.polytech.grade.service;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

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
    public String deleteById(long id) {
        try{
            gradeRepository.deleteById(id);
            return "ok";
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Optional<GradeEntity> findByMark(float mark) {
        return gradeRepository.findByMark(mark);
    }

    @Override
    public Iterable<GradeEntity> findByRecruiter(long id) {
        return gradeRepository.findByRecruiter(id);
    }

    @Override
    public Iterable<GradeEntity> findByJobseeker(long id) {
        return gradeRepository.findByJobseeker(id);
    }


}
