package com.example.pa_backend.entity;

import com.example.pa_backend.enumerations.Weekdays;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity(name = "working_hours")
@Data
public class WorkingHours extends BaseEntity {
    
    @Column
    private Weekdays weekDay;

    @Column
    private Timestamp startTime;

    @Column
    private Timestamp endTime;

    @Column
    private int  therapistId;

    @Column
    private int  therapistAddressId;


}
