package com.polytech.grade.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GradeId implements Serializable {
    private long recruiter;

    private long jobseeker;

    public GradeId(long recruiter, long jobseeker) {
        this.recruiter = recruiter;
        this.jobseeker = jobseeker;
    }

    public GradeId(){}
}
