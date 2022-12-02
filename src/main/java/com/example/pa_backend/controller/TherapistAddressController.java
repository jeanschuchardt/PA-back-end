package com.example.pa_backend.controller;

import com.example.pa_backend.dto.TherapistAddressDTO;
import com.example.pa_backend.service.TherapistAddressService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CommonsLog
@RestController
@RequestMapping("/therapistAddress")
public class TherapistAddressController {

    @Autowired
    private TherapistAddressService therapistAddressService;

    @GetMapping("")
    public Object getAll() {

        return therapistAddressService.getAll() ;
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {

        return therapistAddressService.getById(id);
    }

    @PostMapping("/")
    public Object create(TherapistAddressDTO  therapistAddressDTO) {

        return therapistAddressService.create(therapistAddressDTO);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id, @RequestBody TherapistAddressDTO therapistAddressDTO) {

        return therapistAddressService.update(id,therapistAddressDTO);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable int id) {

        return therapistAddressService.delete(id);
    }
}
