package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.dto.JobseekerCreationDto;
import com.polytech.users.jobseeker.entity.FilesEntity;
import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.entity.OfferEntity;
import com.polytech.users.jobseeker.service.FileService;
import com.polytech.users.jobseeker.service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobseeker")
@RequiredArgsConstructor
@Slf4j
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;
    private final FileService fileService;

    @PostMapping
    ResponseEntity<JobSeekerEntity> save(@ModelAttribute JobseekerCreationDto dto) {
        try {
            FilesEntity cv = fileService.save(dto.getFile());
            return ResponseEntity.ok(jobSeekerService.save(dto.jobSeekerEntity(cv)));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/cv")
    ResponseEntity<JobSeekerEntity> updateCv(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            FilesEntity updatedCv = fileService.save(file);
            return ResponseEntity.ok(jobSeekerService.updateCv(id, updatedCv));
        } catch (IOException | RuntimeException e) {
            log.error("Error occured while updating CV", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/cv/{jobseekerId}")
    ResponseEntity<byte[]> getCv(@PathVariable Long jobseekerId) {
        Optional<JobSeekerEntity> jobseekerOptional = jobSeekerService.findById(jobseekerId);
        if (jobseekerOptional.isEmpty()) {
            return ResponseEntity.notFound()
                .build();
        }
        FilesEntity fileEntity = jobseekerOptional.get().getCv();
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
            .contentType(MediaType.valueOf(fileEntity.getContentType()))
            .body(fileEntity.getData());
    }

    @GetMapping
    Iterable<JobSeekerEntity> findAll() {
        return jobSeekerService.findAll();
    }

    @GetMapping("/{id}")
    Optional<JobSeekerEntity> findById(@PathVariable long id) {
        return jobSeekerService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id) {
        jobSeekerService.deleteById(id);
    }

    @PostMapping("{userId}/apply/{offerId}")
    public ResponseEntity<Void> applyOffer(@PathVariable Long userId, @PathVariable Long offerId) {
        try {
            jobSeekerService.applyOffer(userId, offerId);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
