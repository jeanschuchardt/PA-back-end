package com.example.pa_backend.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;


@Data
public class AgendaDTO  {

    private Date date;
    private Timestamp startTime;
    private Timestamp endTime;
    private int  therapistId;
    private int  clientId;
    private int locationId;
}
