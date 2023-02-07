package com.example.pa_backend.controller;

import com.example.pa_backend.dto.AgendaDTO;
import com.example.pa_backend.dto.AgendaResponseDTO;
import com.example.pa_backend.entity.Agenda;
import com.example.pa_backend.exception.ServiceException;
import com.example.pa_backend.service.AgendaService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CommonsLog
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping("")
    public List<Agenda> getAll() {
        List<Agenda> all = agendaService.getAll();
        return all;
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {
        Agenda byId = agendaService.getById(id);
        return byId;
    }

    @PostMapping("/")
    public Agenda create(@RequestBody AgendaDTO agendaDTO) {
        try {
            return agendaService.create(agendaDTO);
        }catch (Exception e){
            throw  new ServiceException("Horário não disponível", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        agendaService.delete(id);
    }

    @GetMapping("/email/{email}")
    public List<AgendaResponseDTO> getByEmail(@PathVariable String email) {
        List<AgendaResponseDTO> byEmail = agendaService.getByEmail(email);
        return byEmail;
    }
}
