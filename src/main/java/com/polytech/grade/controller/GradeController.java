package com.polytech.grade.controller;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recruiter")
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

    @GetMapping("/{mark}")
    Optional<GradeEntity> findByMark(@PathVariable float mark) {
        return gradeService.findByMark(mark);
    }

}
