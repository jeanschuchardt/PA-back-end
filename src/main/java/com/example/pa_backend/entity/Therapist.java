package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@Entity
public class Therapist extends BaseUser implements User {


}
