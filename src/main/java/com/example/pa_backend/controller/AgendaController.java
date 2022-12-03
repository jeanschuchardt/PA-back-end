package com.example.pa_backend.controller;

import com.example.pa_backend.dto.AgendaDTO;
import com.example.pa_backend.entity.Agenda;
import com.example.pa_backend.service.AgendaService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CommonsLog
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces="application/json")
    public Object getAll() {
        List<Agenda> all = agendaService.getAll();
        return all;
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {
        Agenda byId = agendaService.getById(id);
        return byId;
    }

    @PostMapping("/")
    public Object create(@RequestBody AgendaDTO agendaDTO) {


        return agendaService.create(agendaDTO);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id,
                         @RequestBody AgendaDTO agendaDTO) {


        return agendaService.update(id,agendaDTO);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable int id) {

        return agendaService.delete(id);
    }
}
