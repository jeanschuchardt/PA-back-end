package com.example.pa_backend.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.*;

@CommonsLog
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @GetMapping("")
    public Object getAll() {

        return "";
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {

        return null;
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
