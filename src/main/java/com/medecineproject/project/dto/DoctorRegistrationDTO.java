package com.medecineproject.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRegistrationDTO {
    private String firstName;
    private String lastName;
    private String category;
    private int experience;
    private String login;
    private String password;
}
