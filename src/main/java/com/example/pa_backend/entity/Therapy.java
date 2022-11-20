package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "therapy")
@Data
public class Therapy extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int  therapistId;
}
