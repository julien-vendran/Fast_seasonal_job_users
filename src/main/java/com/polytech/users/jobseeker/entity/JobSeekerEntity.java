package com.polytech.users.jobseeker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "jobseeker")
public class JobSeekerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="last_name", length=100, nullable=false)
    private String lastName;

    @Column(name="first_name", length=100, nullable=false)
    private String firstName;

    @Column(name="city", length=100, nullable=false)
    private String city;

    @Column(name="job", length=100, nullable=false)
    private String job;

    @Column(name="phone", length=20, nullable=false)
    private String phoneNumber;

    @Column(name="email", length=100, nullable=false)
    private String email;
}
