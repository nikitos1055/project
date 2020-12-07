package com.medecineproject.project.model;

import com.medecineproject.project.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "doctor")
public class Doctor extends LoginData{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id", unique = true, nullable = false)
    private long id;

    @Column(name = "doctor_name")
    private String name;

    @Column(name = "doctor_surname")
    private String surname;

    @Column(name = "doctor_category")
    private String category;

    @Column(name = "doctor_experience")
    private Integer experience;

    @Column(name = "doctor_ready_meetings")
    private Integer numOfMeetingsWithPatients;

    @Column(name = "doctor_role")
    private Role role = Role.DOCTOR;

    @Column(name = "doctor_login",unique = true, nullable = false)
    private String login;

    @Column(name = "doctor_password", nullable = false)
    private String password;

    @Column(name = "is_banned")
    private Boolean banned = false;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Meeting> meetings;


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
}
