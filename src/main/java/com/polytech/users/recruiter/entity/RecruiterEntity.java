package com.polytech.users.recruiter.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity(name = "recruiter")
@Table(name = "recruiter")
public class RecruiterEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="lastname", length=100, nullable=false)
    private String lastname;

    @Column(name="firstname", length=100, nullable=false)
    private String firstname;

    @Column(name="companyName", length=100, nullable=false)
    private String companyName;

    @Column(name="city", length=100, nullable=false)
    private String city;

    @Column(name="job", length=100, nullable=false)
    private String job;

    @Column(name="phone", length=20, nullable=false)
    private String phone;

    @Column(name="email", length=100, nullable=false)
    private String email;

}
