package com.medecineproject.project.controller;

import com.google.gson.Gson;
import com.medecineproject.project.dto.DoctorRegistrationDTO;
import com.medecineproject.project.dto.UserRegistrationDTO;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.LoginData;
import com.medecineproject.project.model.User;
import com.medecineproject.project.model.UserLogin;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.impl.DoctorServiceImpl;
import com.medecineproject.project.service.impl.UserServiceImpl;
import com.sun.net.httpserver.Authenticator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@RestController
public class RegistrationController {
    @Autowired
    private final DoctorService serviceDoctors = new DoctorServiceImpl();

    @Autowired
    private final UserServiceImpl serviceUser = new UserServiceImpl();

    @PostMapping("/register-doctor")
    public int registerDoctor(@RequestBody DoctorRegistrationDTO doctorRegistrationDTO, HttpServletRequest req) {
        if (Objects.isNull(serviceUser.readByLogin(doctorRegistrationDTO.getLogin()))) {
            Doctor doctor = new Doctor(doctorRegistrationDTO.getFirstName(), doctorRegistrationDTO.getLastName(), doctorRegistrationDTO.getCategory(),
                    doctorRegistrationDTO.getExperience(), doctorRegistrationDTO.getLogin(), doctorRegistrationDTO.getPassword());
            serviceDoctors.save(doctor);
            log.info("Doctor {} was added", doctor);

            HttpSession session = req.getSession(true);
            session.setAttribute("login", doctor.getLogin());
            return 200;
        }

        return 500;
    }

    @PostMapping("/register-user")
    public int registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO, HttpServletRequest req) {
        if (Objects.isNull(serviceUser.readByLogin(userRegistrationDTO.getLogin()))) {
            User user = new User(userRegistrationDTO.getFirstName(), userRegistrationDTO.getLastName(), userRegistrationDTO.getLogin(), userRegistrationDTO.getPassword());
            serviceUser.save(user);
            log.info("User {} was added", user);

            HttpSession session = req.getSession(true);
            session.setAttribute("login", user.getLogin());
            return 200;
        }
        return 500;
    }
}
