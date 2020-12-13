package com.medecineproject.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medecineproject.project.model.enums.Role;
import com.medecineproject.project.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


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

//    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Meeting> meetings;

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

    @JsonFormat
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", category='" + category + '\'' +
                ", experience=" + experience +
                ", numOfMeetingsWithPatients=" + numOfMeetingsWithPatients +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
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
