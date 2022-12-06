package com.example.pa_backend.service;

import com.example.pa_backend.dto.AgendaDTO;
import com.example.pa_backend.entity.Agenda;
import com.example.pa_backend.entity.TherapyConfiguration;
import com.example.pa_backend.exception.ServiceException;
import com.example.pa_backend.repository.AgendaRepository;
import com.example.pa_backend.repository.TherapyConfigurationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private TherapyConfigurationRepository therapyConfigurationRepository;


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
        //verifica se a tipo de atedimento possui uma pre-configuração
        TherapyConfiguration therapyConfiguration = getTherapyConfiguration(agendaDTO);

        //com a pre-configuração atualiza o horaio que o atendimento ira terminar
        agendaDTO.setEndTime(getEndTime(agendaDTO.getStartTime(),therapyConfiguration));

        // verifica se a data e o horario, assim como o terapeuta e o local esta disponivel
        checkAgendaAvailability(agendaDTO);

        //mapeia o dto para a entity
        Agenda map = mapAgenda(agendaDTO);

        //salva o agendamento
        return agendaRepository.save(map);
    }

    private Agenda mapAgenda(AgendaDTO agendaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);
        Agenda map = modelMapper.map(agendaDTO, Agenda.class);
        return map;
    }

    private LocalTime getEndTime(LocalTime startTime, TherapyConfiguration therapyConfiguration) {
        Duration between = Duration.between(therapyConfiguration.getStartTime(), therapyConfiguration.getEndTime());
        return startTime.plus(between);

    }

    private TherapyConfiguration getTherapyConfiguration(AgendaDTO agendaDTO) {

      return therapyConfigurationRepository
                .findByTherapyIdAndTherapistIdAndTherapistAddressId(agendaDTO.getTherapyId(),
                                                                    agendaDTO.getTherapistId(),
                                                                    agendaDTO.getLocationId())
                .orElseThrow(() -> new ServiceException("Terapia não apresenta configurações pre definidas.",
                                                        HttpStatus.BAD_REQUEST));
    }

    private void checkAgendaAvailability(AgendaDTO agendaDTO) {
        List<Agenda> agendas =
                agendaRepository.findAllByTherapistIdAndDateAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
                        agendaDTO.getTherapistId(),
                        agendaDTO.getDate(),
                        agendaDTO.getStartTime(),
                        agendaDTO.getEndTime());

        if(!agendas.isEmpty()){
            throw  new ServiceException("Horario nao disponível.", HttpStatus.BAD_REQUEST);
        }
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
