package com.lv.cloud.quartz.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Data
public class ScheduleEmailRequest {


    private String email;


    private String subject;


    private String body;


    private String dateTime;

}
