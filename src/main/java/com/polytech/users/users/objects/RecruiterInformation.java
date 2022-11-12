package com.polytech.users.users.objects;

import lombok.Getter;

@Getter
public class RecruiterInformation extends UserInformation {
    private final String companyName;

    public RecruiterInformation(String firstname, String lastname, String location, String job, long phone, String email, String companyName) {
        super(firstname, lastname, location, job, phone, email);
        this.companyName = companyName;
    }
}
