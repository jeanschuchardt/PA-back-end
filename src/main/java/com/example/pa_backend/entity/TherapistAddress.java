package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column
    private int  therapistId;
}
