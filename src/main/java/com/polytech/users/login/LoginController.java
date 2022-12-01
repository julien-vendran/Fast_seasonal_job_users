package com.polytech.users.login;

import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import com.polytech.users.jobseeker.service.JobSeekerService;
import com.polytech.users.recruiter.entity.RecruiterEntity;
import com.polytech.users.recruiter.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class LoginController {
    private final JobSeekerService jobSeekerService;
    private final RecruiterService recruiterService;

    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        String email = loginDto.email();
        if (email == null) {
            return ResponseEntity.badRequest().build();
        }
        return recruiterService.findByEmail(email)
            .map(RecruiterEntity::getId)
            .map(LoginResponseDto::ofRecruiter)
            .map(ResponseEntity::ok)
            .orElseGet(() -> {
                return jobSeekerService.findByEmail(email)
                    .map(LoginResponseDto::ofJobseeker)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.badRequest().build());
            });
    }
}
