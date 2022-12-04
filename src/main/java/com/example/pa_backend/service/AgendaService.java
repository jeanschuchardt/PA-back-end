package com.example.pa_backend.service;

import com.example.pa_backend.dto.AgendaDTO;
import com.example.pa_backend.entity.Agenda;
import com.example.pa_backend.exception.ServiceException;
import com.example.pa_backend.repository.AgendaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;


    public List<Agenda> getAll() {

        List<Agenda> agenda = agendaRepository.findAll();
        if (agenda.isEmpty()) {
            throw new RuntimeException("No content");
        }
        return agenda;

    }


    public Agenda getById(int id) {
        Agenda agenda = agendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return agenda;
    }


    public Agenda create(AgendaDTO agendaDTO) {

        List<Agenda> agendas =
                agendaRepository.findAllByTherapistIdAndDateAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
                        agendaDTO.getTherapistId(),
                        agendaDTO.getDate(),
                        agendaDTO.getStartTime(),
                        agendaDTO.getEndTime());

        if(!agendas.isEmpty()){
            throw  new ServiceException("horario nao disponivel", HttpStatus.BAD_REQUEST);
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);
        Agenda map = modelMapper.map(agendaDTO, Agenda.class);

        return agendaRepository.save(map);
    }


    public Agenda update(int id, AgendaDTO agendaDTO) {
        Agenda byId = getById(id);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);
        modelMapper.map(agendaDTO, byId);

        Agenda save = agendaRepository.save(byId);
        return save;

    }


    public Object delete(int id) {
        Agenda byId = getById(id);
        try {
            agendaRepository.delete(byId);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error on delete");
        }


    }


}
