package com.polytech.users.users.objects;

import lombok.Getter;

@Getter
public class RecruiterInformation extends UserInformation {
    private final String companyName;

    public RecruiterInformation(String name, String lastName, String location, String job, long phone, String email, String companyName) {
        super(name, lastName, location, job, phone, email);
        this.companyName = companyName;
    }
}
