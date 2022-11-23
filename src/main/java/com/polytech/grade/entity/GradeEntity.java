package com.polytech.grade.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@IdClass(GradeId.class)
@Entity(name = "grade")
@Table(name = "grade")
public class GradeEntity {

    @Id
    private Long idRecruiter;

    @Id
    private Long idJobseker;

    @Column(name="mark", nullable=false)
    private float mark;

    @Column(name="comment", length=200, nullable=false)
    private String comment;

}
