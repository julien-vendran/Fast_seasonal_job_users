package com.polytech.users.jobseeker.controller;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobseeker")
@RequiredArgsConstructor
@Slf4j
public class JobSeekerController {
    private final JobSeekerRepository jobSeekerRepository;
    private final RestTemplate restTemplate;
    private final KafkaSenderController kafkaSenderController;

    @PostMapping
    JobSeekerEntity save(JobSeekerEntity jobSeekerEntity) {
        return jobSeekerRepository.save(jobSeekerEntity);
    }

    @GetMapping()
    Iterable<JobSeekerEntity> findAll() {
        return jobSeekerRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<JobSeekerEntity> findById(@PathVariable long id) {
        return jobSeekerRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id) {
        jobSeekerRepository.deleteById(id);
    }

    @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }

    @RolesAllowed("user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User");
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public ResponseEntity<String> generateToken(@PathParam("username") String username, @PathParam("password") String password) {
        Map<String, String> body = Map.of("grant_type", "password",
            "client_id", "users-microservice",
            "client_secret", "82Fsy7KCd3ay1FWRpm7AzNe45ycj3DRE",
            "username", username,
            "passowrd", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        var httpEntity = new HttpEntity<>(body, headers);


        String url = "http://localhost:8080/realms/SpringBootKeycloak/protocol/openid-connect/token";
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    }

    @GetMapping("/kafka")
    ResponseEntity<String> testKafka() {
        kafkaSenderController.sendMessage("Je suis une chaussure", "topicName");
        return ResponseEntity.ok("Cooml");
    }
}
