package com.medecineproject.project.controller;

import com.medecineproject.project.dto.UserRegistrationDTO;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.User;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.impl.DoctorServiceImpl;
import com.medecineproject.project.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private final DoctorService serviceDoctors = new DoctorServiceImpl();

    @Autowired
    private final UserServiceImpl serviceUser = new UserServiceImpl();

    @PostMapping("/update-user")
    public int registerUser(@RequestBody User user) {
        log.info(String.valueOf(user));
        User getUser = serviceUser.readByLogin(user.getLogin());
        log.info(String.valueOf(getUser));

            getUser.setName(user.getName());
            getUser.setSurname(user.getSurname());
            serviceUser.save(getUser);
            log.info("User {} was updated", user);
            return 200;
    }

    @PostMapping("/update-doctor")
    public int registerUser(@RequestBody Doctor doctor) {
        Doctor getDoc = serviceDoctors.readByLogin(doctor.getLogin());
        log.info(String.valueOf(getDoc));

            getDoc.setName(doctor.getName());
            getDoc.setSurname(doctor.getSurname());
            getDoc.setCategory(doctor.getCategory());
            getDoc.setExperience(doctor.getExperience());

            serviceDoctors.save(getDoc);
            log.info("User {} was updated", getDoc);
            return 200;
    }

}
