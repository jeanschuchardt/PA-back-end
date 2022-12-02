package com.example.pa_backend.controller;

import com.example.pa_backend.entity.user.Client;
import com.example.pa_backend.repository.ClientRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CommonsLog
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("")
    public Object getAll() {
        throw  new RuntimeException("Not implemented");

    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable int id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PostMapping("/")
    public Object create() {

        throw  new RuntimeException("Not implemented");
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id) {

        throw  new RuntimeException("Not implemented");
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable int id) {

        throw  new RuntimeException("Not implemented");
    }
}
