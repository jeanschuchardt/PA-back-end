package com.example.pa_backend.entity.user;

import com.example.pa_backend.entity.TherapistAddress;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Accessors(chain = true)
@Entity(name = "therapist")
public class Therapist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String therapy;

    @Column
    private String address;



}
