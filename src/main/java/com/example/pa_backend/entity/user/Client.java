package com.example.pa_backend.entity.user;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "client")
public class Client  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

}
