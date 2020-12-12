package com.medecineproject.project.model;

import com.medecineproject.project.model.enums.Role;
import com.medecineproject.project.model.enums.Status;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "doctor")
public class Doctor extends LoginData {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id", unique = true, nullable = false)
    private long id;

    @Getter
    @Setter
    @Column(name = "doctor_name")
    private String name;

    @Getter
    @Setter
    @Column(name = "doctor_surname")
    private String surname;

    @Getter
    @Setter
    @Column(name = "doctor_category")
    private String category;

    @Getter
    @Setter
    @Column(name = "doctor_experience")
    private Integer experience;

    @Getter
    @Setter
    @Column(name = "doctor_ready_meetings")
    private Integer numOfMeetingsWithPatients = 0;

    @Getter
    @Setter
    @Column(name = "doctor_role")
    private Role role = Role.DOCTOR;

    @Getter
    @Setter
    @Column(name = "doctor_login", unique = true, nullable = false)
    private String login;

    @Getter
    @Setter
    @Column(name = "doctor_password", nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name = "status")
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Meeting> meetings;

    public Doctor(Integer numOfMeetingsWithPatients) {
        this.numOfMeetingsWithPatients = numOfMeetingsWithPatients;
    }

    public Doctor(String name, String surname, String category, Integer experience, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.category = category;
        this.experience = experience;
        this.login = login;
        this.password = password;
    }

    public Doctor(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Doctor(String name, String surname, String category, Integer experience, String login) {
        this.name = name;
        this.surname = surname;
        this.category = category;
        this.experience = experience;
        this.login = login;
    }


}
