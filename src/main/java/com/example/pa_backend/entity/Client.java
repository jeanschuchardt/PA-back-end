package com.example.pa_backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "client")
public class Client extends BaseUser implements User {


}
