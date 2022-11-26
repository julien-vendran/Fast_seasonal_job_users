package com.polytech.grade.controller;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.entity.GradeId;
import com.polytech.grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping
    ResponseEntity<GradeEntity> save(@RequestBody GradeEntity gradeEntity) {
        return gradeService.save(gradeEntity);
    }

    @GetMapping("/all")
    Iterable<GradeEntity> findAll() {
        return gradeService.findAll();
    }

    @GetMapping
    Optional<GradeEntity> findById(@RequestBody GradeId idGrade) {
        return gradeService.findById(idGrade);
    }

    @DeleteMapping
    ResponseEntity<String> deleteById(@RequestBody GradeId idGrade) {
        return gradeService.deleteById(idGrade);
    }

    @GetMapping("/mark/{mark}")
    Iterable<GradeEntity> findByMark(@PathVariable int mark) {
        return gradeService.findByMark(mark);
    }

    @GetMapping("/recruiter/{idRecruiter}")
    Iterable<GradeEntity> findByRecruiter(@PathVariable long idRecruiter){
        return gradeService.findByRecruiter(idRecruiter);
    }

    @GetMapping("/jobseeker/{idJobseeker}")
    Iterable<GradeEntity> findByJobseeker(@PathVariable long idJobseeker){
        return gradeService.findByJobseeker(idJobseeker);
    }

}
