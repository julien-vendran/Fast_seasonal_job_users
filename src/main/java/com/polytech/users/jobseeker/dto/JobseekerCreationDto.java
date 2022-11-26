package com.polytech.users.jobseeker.dto;

import com.polytech.users.jobseeker.entity.FilesEntity;
import com.polytech.users.jobseeker.entity.JobSeekerEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
public class JobseekerCreationDto implements Serializable {

    private String lastname;
    private String firstname;
    private String city;
    private String job;
    private String phone;
    private String email;
    private String keywords;
    private MultipartFile file;
    public JobSeekerEntity jobSeekerEntity(FilesEntity registeredCv) {
        return new JobSeekerEntity(
            null,
            registeredCv,
            getLastname(),
            getFirstname(),
            getCity(),
            getJob(),
            getPhone(),
            getEmail(),
            getKeywords()
        );
    }
}
