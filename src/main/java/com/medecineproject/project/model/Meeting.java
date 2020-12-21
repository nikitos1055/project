package com.medecineproject.project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meeting_id", unique = true, nullable = false)
    private long id;

    @Column(name = "meeting_time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Meeting(String time, Doctor doctor, User user) {
        this.time = time;
        this.doctor = doctor;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id &&
                Objects.equals(time, meeting.time) &&
                Objects.equals(doctor, meeting.doctor) &&
                Objects.equals(user, meeting.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, doctor, user);
    }
}
