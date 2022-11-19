package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "workinghours")
public class WorkingHours extends BaseEntity {
    
    @Column
    private String weekDay;

    @Column
    private Timestamp startTime;

    @Column
    private Timestamp endTime;

    @Column
    private int  therapistId;

    @Column
    private int  therapistAddressId;

}
