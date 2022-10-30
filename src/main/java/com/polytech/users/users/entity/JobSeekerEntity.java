package com.polytech.users.users.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "jobseeker")
@Getter
@Setter
@ToString
public class JobSeekerEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String last_name;
    @Column
    private String first_name;
    @Column
    private String city;
    @Column
    private String job;
    @Column
    private String phone;
    @Column
    private String email;
}
