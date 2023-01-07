package com.example.pa_backend.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Data
public class AgendaDTO  {

    private int  therapistId;
    private LocalDate date;
    private LocalTime time;
    private String clientName;
    private String clientEmail;
    private String  address;

}
