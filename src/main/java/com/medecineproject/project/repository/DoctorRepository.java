package com.medecineproject.project.repository;

import com.medecineproject.project.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long>,
        CrudRepository<Doctor , Long> {

        List<Doctor> findAllByCategory(String category);

        Doctor readByLogin(String login);

        Doctor readTopByNumOfMeetingsWithPatients(Integer numOfMeetingsWithPatients);
}
