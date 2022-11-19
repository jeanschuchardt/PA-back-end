package com.example.pa_backend.controller;

import org.springframework.web.bind.annotation.*;

public interface Base1Controller<T> {

    @GetMapping("")
    public T getAll() ;

    @GetMapping("/{id}")
    public T getById(@PathVariable int id) ;

    @PostMapping("/")
    public T create();
;
    @PutMapping("/{id}")
    public T update(@PathVariable int id);

    @DeleteMapping("/{id}")
    public T delete(@PathVariable int id) ;
}
