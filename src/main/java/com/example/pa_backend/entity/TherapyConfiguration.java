package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "therapy_configuration")
@Data
public class TherapyConfiguration extends BaseEntity {

    @Column
    private Date date;

    @Column
    private Timestamp startTime;

    @Column
    private Timestamp endTime;

    @Column
    private int  therapistId;

    @Column
    private int  therapistAddressId;
}
