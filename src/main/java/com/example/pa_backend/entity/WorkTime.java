package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "worktime")
public class WorkTime extends BaseEntity {

    @Column
    private String weekDay;

    @Column
    private int  therapistId;

}
