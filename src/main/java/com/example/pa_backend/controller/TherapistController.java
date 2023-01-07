package com.example.pa_backend.controller;

import com.example.pa_backend.dto.DataDTO;
import com.example.pa_backend.entity.user.Therapist;
import com.example.pa_backend.exception.ServiceException;
import com.example.pa_backend.repository.TherapistRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CommonsLog
@RestController
@RequestMapping("/therapist")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TherapistController {
@Autowired
    TherapistRepository therapistRepository;

    @GetMapping("")
    public Object getAll() {
        List<Therapist> all = therapistRepository.findAll();
        return all;
    }

    @GetMapping("/{id}")
    public Therapist getById(@PathVariable int id) {
        Therapist t = therapistRepository.findById(id).orElseThrow(
                () -> new ServiceException("Nao encontrado", HttpStatus.BAD_REQUEST));
        return t;

    }

    @PostMapping("")
    public Therapist create(@RequestBody DataDTO data) {
        Therapist therapist = new Therapist().setName(data.getName()).setEmail(data.getEmail());

        return therapistRepository.save(therapist);
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
