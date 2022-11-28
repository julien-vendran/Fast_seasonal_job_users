package com.polytech.users.jobseeker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "offer")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long idOffer;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @Column(name = "publish_day", nullable = false)
    private Date publishDay;

    @Column(name = "job_starting_date", nullable = false)
    private Date jobStartingDate;

    @Column(name = "location", length = 100, nullable = false)
    private String location;

    @Column(name = "jobnumber", nullable = false)
    private Integer jobNumber;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "advantages", length = 500, nullable = false)
    private String advantages;

    @Column(name = "job", length = 100, nullable = false)
    private String job;

    @Column(name = "zones", length = 100, nullable = false)
    private String zones;

    @Column(name = "author", length = 100, nullable = false)
    private String author;

    @Column(name = "keywords", length = 100, nullable = false)
    private String keywords;

    @ManyToMany
    private Set<JobSeekerEntity> jobseekers;

    public Set<JobSeekerEntity> getJobseekers() {
        return jobseekers == null ? new HashSet<>() : jobseekers;
    }
}