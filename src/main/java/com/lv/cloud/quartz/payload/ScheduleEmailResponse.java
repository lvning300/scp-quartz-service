package com.lv.cloud.quartz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEmailResponse {

    private boolean success;
    private String jobId;
    private String jobGroup;
    private String message;


    public ScheduleEmailResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
