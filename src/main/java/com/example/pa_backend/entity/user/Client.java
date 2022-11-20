package com.example.pa_backend.entity.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity(name = "client")
public class Client extends BaseUser implements User {


}
