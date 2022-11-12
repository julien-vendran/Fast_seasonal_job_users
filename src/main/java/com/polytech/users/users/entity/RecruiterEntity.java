package com.polytech.users.users.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recruiter")
@Getter
@Setter
@ToString
public class RecruiterEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private String companyName;
    @Column
    private String city;
    @Column
    private String job;
    @Column
    private String phone;
    @Column
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RecruiterEntity recruiter))
            return false;
        return Objects.equals(this.id, recruiter.id)
                && Objects.equals(this.firstname, recruiter.firstname)
                && Objects.equals(this.lastname, recruiter.lastname)
                && Objects.equals(this.companyName, recruiter.companyName)
                && Objects.equals(this.city, recruiter.city)
                && Objects.equals(this.job, recruiter.job)
                && Objects.equals(this.phone, recruiter.phone)
                && Objects.equals(this.email, recruiter.email);
    }

}
