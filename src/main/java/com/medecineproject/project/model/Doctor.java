package com.medecineproject.project.model;

import com.medecineproject.project.model.enums.Role;
import com.medecineproject.project.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "doctor")
public class Doctor extends LoginData {
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
    private Integer numOfMeetingsWithPatients = 0;

    @Column(name = "doctor_role")
    private Role role = Role.DOCTOR;

    @Column(name = "doctor_login", unique = true, nullable = false)
    private String login;

    @Column(name = "doctor_password", nullable = false)
    private String password;

    @Column(name = "status")
    private Status status = Status.ACTIVE;

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

    public Doctor(long id, String name, String surname, String category, Integer experience, Integer numOfMeetingsWithPatients, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.category = category;
        this.experience = experience;
        this.numOfMeetingsWithPatients = numOfMeetingsWithPatients;
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id &&
                Objects.equals(name, doctor.name) &&
                Objects.equals(surname, doctor.surname) &&
                Objects.equals(category, doctor.category) &&
                Objects.equals(experience, doctor.experience) &&
                Objects.equals(numOfMeetingsWithPatients, doctor.numOfMeetingsWithPatients) &&
                role == doctor.role &&
                Objects.equals(login, doctor.login) &&
                Objects.equals(password, doctor.password) &&
                status == doctor.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, category, experience, numOfMeetingsWithPatients, role, login, password, status);
    }
}
