package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "therapy_period")
public class TherapyPeriod extends BaseEntity {

    @Column
    private Timestamp therapy_period;

    @Column
    private int  therapyId;

    @Column
    private int  clientId;
}
