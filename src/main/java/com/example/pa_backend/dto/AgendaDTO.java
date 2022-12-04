package com.example.pa_backend.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Data
public class AgendaDTO  {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int  therapistId;
    private int  clientId;
    private int locationId;
    private int  therapyId;
}
