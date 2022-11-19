package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Entity;


@Data
@Entity
public class Client extends BaseUser implements User {


}
