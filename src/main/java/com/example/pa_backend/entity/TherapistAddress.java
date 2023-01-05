package com.example.pa_backend.entity;

import com.example.pa_backend.entity.user.Therapist;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "therapist_address")
@Data
public class TherapistAddress extends BaseEntity {

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String zipcode;

    @Column(name = "province_state")
    private String  provinceState;

    @Column
    private String  country;

//    @Column
//    private int  therapistId;

    @ManyToOne
    @JoinColumn(name="terapistId")
    private Therapist therapist;
}
