package com.example.pa_backend.entity;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity(name = "therapy_configuration")
@Data
public class TherapyConfiguration extends BaseEntity {

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private int  therapyId;

    @Column
    private int  therapistId;

    @Column
    private int  therapistAddressId;
}
