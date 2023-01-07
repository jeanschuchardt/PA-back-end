package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "agenda")
@Data
@Table(name = "agenda")
public class Agenda extends BaseEntity {
    @Column
    private int therapistId;

    @Column
    private LocalDate date;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private String clientName;
    @Column
    private String clientEmail;
    @Column
    private String address;
}
