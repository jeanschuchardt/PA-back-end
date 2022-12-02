package com.example.pa_backend.service;

import com.example.pa_backend.dto.TherapistAddressDTO;
import com.example.pa_backend.entity.TherapistAddress;
import com.example.pa_backend.repository.TherapistAddressRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapistAddressService {

    @Autowired
    private TherapistAddressRepository therapistAddressRepository;


    public List<TherapistAddress> getAll() {

        List<TherapistAddress> TherapistAddress = therapistAddressRepository.findAll();
        if (TherapistAddress.isEmpty()) {
            throw new RuntimeException("No content");
        }
        return TherapistAddress;

    }


    public TherapistAddress getById(int id) {
        TherapistAddress TherapistAddress = therapistAddressRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return TherapistAddress;
    }


    public TherapistAddress create(TherapistAddressDTO TherapistAddressDTO) {
        ModelMapper modelMapper = new ModelMapper();
        TherapistAddress map = modelMapper.map(TherapistAddressDTO, TherapistAddress.class);

        return therapistAddressRepository.save(map);
    }


    public TherapistAddress update(int id, TherapistAddressDTO TherapistAddressDTO) {
        TherapistAddress byId = getById(id);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);
        modelMapper.map(TherapistAddressDTO, byId);

        TherapistAddress save = therapistAddressRepository.save(byId);
        return save;

    }


    public Object delete(int id) {
        TherapistAddress byId = getById(id);
        try {
            therapistAddressRepository.delete(byId);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error on delete");
        }


    }


}
