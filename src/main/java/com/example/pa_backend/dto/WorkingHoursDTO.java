package com.example.pa_backend.dto;

import com.example.pa_backend.enumerations.Weekdays;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class WorkingHoursDTO {


    private Weekdays weekDay;


    private Timestamp startTime;


    private Timestamp endTime;


    private int  therapistId;


    private int  therapistAddressId;


}
