package com.polytech.users.users.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "recruiter")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class RecruiterEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String lastname;
    @Column
    private String firstname;
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

}
