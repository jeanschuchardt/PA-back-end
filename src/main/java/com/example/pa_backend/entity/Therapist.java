package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "therapist")
public class Therapist extends BaseUser implements User {


}
