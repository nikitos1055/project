package com.medecineproject.project.service;

import com.medecineproject.project.model.Meeting;

import java.util.List;
import java.util.Optional;

public interface MeetingService {
    Meeting save(Meeting meeting);

    Optional<Meeting> findById(long id);

    List<Meeting> findAll();

    Meeting update(Meeting meeting);

    void deleteById(long id);

    Meeting readByTime(String time);

    boolean isExists(long id);

    Meeting readById(long id);

    List<Meeting> findAllByDoctorId(long id);
}
