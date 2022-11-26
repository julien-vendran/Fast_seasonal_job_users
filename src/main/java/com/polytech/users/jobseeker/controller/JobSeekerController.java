package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.entity.FilesEntity;
import com.polytech.users.jobseeker.entity.JobSeekerEntity;
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
    JobSeekerEntity save(@RequestBody JobSeekerEntity jobSeeker) {
        return jobSeekerService.save(jobSeeker);
    }

    @PutMapping("/cv/{id}")
    ResponseEntity<FilesEntity> uploadCV(@PathVariable long id, @RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(fileService.save(id, file));
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/cv/{id}")
    ResponseEntity<byte[]> getCv(@PathVariable Long id) {
        Optional<FilesEntity> fileEntityOptional = fileService.getFile(id);
        if (fileEntityOptional.isEmpty()) {
            return ResponseEntity.notFound()
                .build();
        }
        FilesEntity fileEntity = fileEntityOptional.get();
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
}
