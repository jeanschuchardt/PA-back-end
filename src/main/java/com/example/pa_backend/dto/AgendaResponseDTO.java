package com.example.pa_backend.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Accessors(chain = true)
public class AgendaResponseDTO {
    private int  id;
    String thearapistName;
    String thearapistEmail;
    private int  therapistId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String clientName;
    private String clientEmail;
    private String  address;


}
