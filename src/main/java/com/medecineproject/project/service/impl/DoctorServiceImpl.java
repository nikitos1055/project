package com.medecineproject.project.service.impl;

import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.repository.DoctorRepository;
import com.medecineproject.project.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository rep;

    @Override
    public Doctor save(Doctor doctor) {
        return rep.save(doctor);
    }

    @Override
    public Optional<Doctor> findById(long id) {
        return rep.findById(id);
    }

    @Override
    public List<Doctor> findAll() {
        return rep.findAll();
    }

    @Override
    public Doctor update(Doctor doctor) {
        return rep.save(doctor);
    }

    @Override
    public void deleteById(long id) {
        rep.deleteById(id);
    }

    @Override
    public boolean isExists(long id) {
        return rep.existsById(id);
    }

    @Override
    public List<Doctor> findAllByCategory(String category) {
        return rep.findAllByCategory(category);
    }

    @Override
    public Doctor readTopByNumOfMeetingsWithPatients(Integer numOfMeetingsWithPatients) {
        return rep.readTopByNumOfMeetingsWithPatients(numOfMeetingsWithPatients);
    }

    @Override
    public Doctor readByLogin(String login) {
        return rep.readByLogin(login);
    }
}
