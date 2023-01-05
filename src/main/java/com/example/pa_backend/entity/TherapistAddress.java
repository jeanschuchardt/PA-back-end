package com.example.pa_backend.entity;

import com.example.pa_backend.entity.user.Therapist;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column
    private int  terapistId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="terapistId",referencedColumnName = "id", insertable = false, updatable = false)
    private Therapist therapist;
}
