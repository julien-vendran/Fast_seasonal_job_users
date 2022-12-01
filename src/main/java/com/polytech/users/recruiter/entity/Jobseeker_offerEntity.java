package com.polytech.users.recruiter.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "jobseeker_offer")
@JsonInclude(NON_NULL)
@IdClass(Jobseeker_offerId.class)
public class Jobseeker_offerEntity {
    @Id
    private Long jobseeker_id;

    @Id
    private Long offer_id;

    @Column(name = "approved")
    private boolean approved;

}
