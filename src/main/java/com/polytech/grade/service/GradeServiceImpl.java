package com.polytech.grade.service;

import com.polytech.grade.entity.GradeEntity;
import com.polytech.grade.entity.GradeId;
import com.polytech.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class GradeServiceImpl implements GradeService {

    public final GradeRepository gradeRepository;

    @Override
    public ResponseEntity<GradeEntity> save(GradeEntity grade) {

        Iterable<Long> hasJSworkedWithRecruiter = gradeRepository.hasWorkedTogether(grade.getRecruiter(), grade.getJobseeker());

        List<Long> toList = StreamSupport.stream(hasJSworkedWithRecruiter.spliterator(), false).toList();
        try {
            if (!toList.isEmpty()) { //the recruiter and jobseeker have worked together before
                return ResponseEntity.ok(gradeRepository.save(grade));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        log.error("Recruiter and Jobseeker haven't worked together, save impossible.");
        return ResponseEntity.badRequest().build();
    }

    @Override
    public Iterable<GradeEntity> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<GradeEntity> findById(GradeId idGrade) {
        return gradeRepository.findById(idGrade);
    }

    @Override
    public ResponseEntity<String> deleteById(GradeId idGrade) {
        try {
            gradeRepository.deleteById(idGrade);
            return ResponseEntity.ok("Delete grade completed.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public Iterable<GradeEntity> findByMark(int mark) {
        return gradeRepository.findByMark(mark);
    }

    @Override
    public Iterable<GradeEntity> findByRecruiter(long recruiter) {
        return gradeRepository.findByRecruiter(recruiter);
    }

    @Override
    public Iterable<GradeEntity> findByJobseeker(long jobseeker) {
        return gradeRepository.findByJobseeker(jobseeker);
    }


}
