package com.example.pa_backend.controller;

import com.example.pa_backend.entity.user.Therapist;
import com.example.pa_backend.exception.ServiceException;
import com.example.pa_backend.repository.TherapistRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CommonsLog
@RestController
@RequestMapping("/therapist")
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8080", "*", "http://192.168.1.8:8081"})
public class TherapistController {
@Autowired
    TherapistRepository therapistRepository;

    @GetMapping("")
    public Object getAll() {
        List<Therapist> all = therapistRepository.findAll();
        return all;
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {
        Therapist t = therapistRepository.findById(id).orElseThrow(
                () -> new ServiceException("Nao encontrado", HttpStatus.BAD_REQUEST));
        return t;

    }

    @PostMapping("/")
    public Object create() {

        return null;
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id) {

        return null;
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable int id) {

        return null;
    }
}
