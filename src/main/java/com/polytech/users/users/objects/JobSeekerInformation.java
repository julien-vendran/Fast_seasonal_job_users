package com.polytech.users.users.objects;

import lombok.Getter;

import java.io.File;

@Getter
public class JobSeekerInformation extends UserInformation {

    private final File resume;
    public JobSeekerInformation(String name, String lastName, String location, String job, long phone, String email, File resume) {
        super(name, lastName, location, job, phone, email);
        this.resume = resume;
    }
}


