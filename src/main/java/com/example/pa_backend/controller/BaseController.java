package com.example.pa_backend.controller;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CommonsLog
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8080", "*", "http://192.168.1.8:8081"})
public class BaseController {
    @GetMapping("/test")
    public List<SimpleObject> getAll() {

        return List.of(new SimpleObject()
                               .setId(1)
                               .setAge(31)
                               .setName("Fran"),
                       new SimpleObject()
                               .setId(2)
                               .setAge(29)
                               .setName("Jean"),
                       new SimpleObject()
                               .setId(3)
                               .setAge(43)
                               .setName("Ivi"));


    }
}

@Data
@Accessors(chain = true)
class SimpleObject {
    int id;
    String name;
    int age;
}