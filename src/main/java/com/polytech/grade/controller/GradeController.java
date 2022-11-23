package com.polytech.grade.controller;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping
    GradeEntity save(@RequestBody GradeEntity gradeEntity) {
        return gradeService.save(gradeEntity);
    }

    @GetMapping
    Iterable<GradeEntity> findAll() {
        return gradeService.findAll();
    }

    @GetMapping("/{id}")
    Optional<GradeEntity> findById(@PathVariable long id) {
        return gradeService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        gradeService.deleteById(id);
    }

    @GetMapping("/mark/{mark}")
    Optional<GradeEntity> findByMark(@PathVariable float mark) {
        return gradeService.findByMark(mark);
    }

    @GetMapping("/recruiter/{id}")
    Iterable<GradeEntity> findByRecruiter(@PathVariable long id){
        return gradeService.findByRecruiter(id);
    }

    @GetMapping("/jobseeker/{id}")
    Iterable<GradeEntity> findByJobseeker(@PathVariable long id){
        return gradeService.findByJobseeker(id);
    }

}
