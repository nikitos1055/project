package com.medecineproject.project.model;

import lombok.*;

import javax.persistence.*;


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

    @ManyToOne(optional = false)
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
}
