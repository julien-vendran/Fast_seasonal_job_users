package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.dto.CredentialsDto;
import com.polytech.users.jobseeker.dto.JobSeekerCreationDto;
import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobseeker")
@RequiredArgsConstructor
@Slf4j
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;
    private final KafkaSenderController kafkaSenderController;

    @PostMapping
    JobSeekerEntity save(@RequestBody JobSeekerEntity jobSeekerEntity) {
        return jobSeekerService.save(jobSeekerEntity);
    }

    @GetMapping()
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

    @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }

    @RolesAllowed("app-admin")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User");
    }

    @PostMapping("/token")
    public ResponseEntity<String> generateToken(@RequestBody CredentialsDto credentials) {
        if (Objects.isNull(credentials)) {
            return ResponseEntity.badRequest().build();
        }
        return jobSeekerService.generateToken(credentials.username(), credentials.password());
    }

    @GetMapping("/kafka")
    ResponseEntity<String> testKafka() {
        kafkaSenderController.sendMessage("Je suis une chaussure", "topicName");
        return ResponseEntity.ok("Cooml");
    }
}
