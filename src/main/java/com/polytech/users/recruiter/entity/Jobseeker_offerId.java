package com.polytech.users.recruiter.entity;

import javax.persistence.IdClass;
import java.io.Serializable;
public class Jobseeker_offerId implements Serializable {
    private Long jobseeker_id;

    private Long offer_id;

    public Jobseeker_offerId(Long jsId, Long offerId) {
        this.jobseeker_id = jsId;
        this.offer_id = offerId;
    }
}
