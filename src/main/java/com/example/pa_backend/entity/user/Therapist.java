package com.example.pa_backend.entity.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity(name = "therapist")
public class Therapist extends BaseUser implements User {


}
