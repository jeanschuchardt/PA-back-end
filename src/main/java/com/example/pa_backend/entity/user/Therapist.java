package com.example.pa_backend.entity.user;

import com.example.pa_backend.entity.TherapistAddress;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
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

    @OneToMany(mappedBy="therapist")
    private Set<TherapistAddress> addresses;

}
