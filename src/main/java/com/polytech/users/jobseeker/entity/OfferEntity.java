package com.polytech.users.jobseeker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "offer")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long idOffer;
}