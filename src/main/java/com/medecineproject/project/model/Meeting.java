package com.medecineproject.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "meeting_cabinet")
    private Integer cabinet;

    @Column(name = "meeting_price")
    private Integer price;

    @ManyToOne(optional=false)
    @JoinColumn(name="doctor_id",referencedColumnName="doctor_id")
    private Doctor doctor;

    @ManyToOne(optional=false)
    @JoinColumn(name="user_id",referencedColumnName="user_id")
    private User user;
}
