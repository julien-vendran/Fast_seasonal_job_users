package com.polytech.users.users.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "jobseeker")
@Getter
@Setter
public class JobSeekerEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
}
