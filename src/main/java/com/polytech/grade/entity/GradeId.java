package com.polytech.grade.entity;

import java.io.Serializable;

public class GradeId implements Serializable {
    private final long idRecruiter;

    private final long idJobseker;

    public GradeId(long idRecruiter, long idJobseker) {
        this.idRecruiter = idRecruiter;
        this.idJobseker = idJobseker;
    }
}
