package com.medecineproject.project.dto;

import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDTO {
    private String time;
    private Doctor doctor;
    private User user;
}
