package com.polytech.users.jobseeker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    private FilesEntity cv;

    @Column(name = "lastname", length = 100, nullable = false)
    private String lastname;

    @Column(name = "firstname", length = 100, nullable = false)
    private String firstname;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "region", length = 100, nullable = false)
    private String region;

    @Column(name = "job", length = 100, nullable = false)
    private String job;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "keywords", length = 500)
    private String keywords; // Split on ","

    @ManyToMany
    @JoinTable(
        name = "jobseeker_offer",
        joinColumns = @JoinColumn(name = "jobseeker_id"),
        inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private Set<OfferEntity> offers;

    public Set<OfferEntity> getOffers() {
        return offers == null ? new HashSet<>() : offers;
    }
}
