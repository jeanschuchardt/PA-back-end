package com.example.pa_backend.repository;

import com.example.pa_backend.entity.Agenda;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Repository
public interface AgendaRepository extends BaseRepository<Agenda> {


    List<Agenda> findAllByTherapistIdAndDateAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(int id, LocalDate date,
                                                                                         LocalTime startTime,
                                                                                         LocalTime endTime);
}
