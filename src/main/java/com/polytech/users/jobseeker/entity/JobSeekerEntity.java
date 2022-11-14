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
@Entity
@Table(name = "jobseeker")
public class JobSeekerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="lastname", length=100, nullable=false)
    private String lastName;

    @Column(name="firstname", length=100, nullable=false)
    private String firstName;

    @Column(name="city", length=100, nullable=false)
    private String city;

    @Column(name="job", length=100, nullable=false)
    private String job;

    @Column(name="phone", length=20, nullable=false)
    private String phone;

    @Column(name="email", length=100, nullable=false)
    private String email;
}
