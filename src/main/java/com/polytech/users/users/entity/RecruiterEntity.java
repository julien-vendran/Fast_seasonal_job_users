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
    //TODO: change first_name to firstname and last_name to lastname

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String last_name;
    @Column
    private String first_name;
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
                && Objects.equals(this.first_name, recruiter.first_name)
                && Objects.equals(this.last_name, recruiter.last_name)
                && Objects.equals(this.companyName, recruiter.companyName)
                && Objects.equals(this.city, recruiter.city)
                && Objects.equals(this.job, recruiter.job)
                && Objects.equals(this.phone, recruiter.phone)
                && Objects.equals(this.email, recruiter.email);
    }

}
