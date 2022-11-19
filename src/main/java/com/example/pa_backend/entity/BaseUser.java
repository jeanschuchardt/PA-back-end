package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class BaseUser extends BaseEntity implements User {

    @Column
    private String name;

    @Column
    private String email;
}
