package com.medecineproject.project.service;

import com.medecineproject.project.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor save(Doctor doctor);

    Optional<Doctor> findById(long id);

    List<Doctor> findAll();

    Doctor update(Doctor doctor);

    void deleteById(long id);

    boolean isExists(long id);

    List<Doctor> findAllByCategory(String category);

    Doctor readTop();

    Doctor readByLogin(String login);

    Doctor readById(long id);
}
