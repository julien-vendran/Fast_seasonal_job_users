package com.polytech.grade.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@IdClass(GradeId.class)
@Entity(name = "grade")
@Table(name = "grade")
public class GradeEntity implements Serializable {

    @Id
    @Column(name = "recruiter", nullable = false)
    private Long recruiter;

    @Id
    @Column(name = "jobseeker", nullable = false)
    private Long jobseeker;

    @Column(name="mark", nullable=false)
    private int mark;

    @Column(name="comment", length=200, nullable=false)
    private String comment;
}
