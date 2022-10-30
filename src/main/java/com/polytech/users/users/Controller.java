package com.polytech.users.users;

import com.polytech.users.users.entity.JobSeekerEntity;
import com.polytech.users.users.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller { //TODO: Delete. Keep only as an example for the moment

    private final JobSeekerRepository jobSeekerRepository;
    @GetMapping
    Iterable<JobSeekerEntity> test() {
        var list = jobSeekerRepository.findAll();

        list.forEach(item -> log.debug(item.toString()));

        return list;
    }
}
