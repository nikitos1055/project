package com.medecineproject.project.controller;

import com.medecineproject.project.dto.UserDTO;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.LoginData;
import com.medecineproject.project.model.User;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.UserService;
import com.medecineproject.project.service.impl.DoctorServiceImpl;
import com.medecineproject.project.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private final DoctorService serviceDoctors = new DoctorServiceImpl();
    @Autowired
    private final UserService serviceUser = new UserServiceImpl();

    @PostMapping("/login")
    public int loginDoctor(@RequestBody UserDTO userDTO, HttpServletRequest req) {
        System.out.println(userDTO);
        if (!Objects.isNull(serviceUser.readByLogin(userDTO.getLogin()))) {
            User user = serviceUser.readByLogin(userDTO.getLogin());
            if (!user.getPassword().equals(userDTO.getPassword())) return 409;
            log.info("User {} was entered", user);

            HttpSession session = req.getSession(true);
            session.setAttribute("login", user.getLogin());
            return 200;
        } else if (!Objects.isNull(serviceDoctors.readByLogin(userDTO.getLogin()))) {
            Doctor doctor = serviceDoctors.readByLogin(userDTO.getLogin());
            if (!doctor.getPassword().equals(userDTO.getPassword())) return 409;
            log.info("Doctor {} was entered", doctor);

            HttpSession session = req.getSession(true);
            session.setAttribute("login", doctor.getLogin());
            return 200;
        }
        return 500;
    }

    @GetMapping("/getData")
    public LoginData getData(HttpServletRequest req) {
        String login = req.getSession().getAttribute("login").toString();

        if (!Objects.isNull(serviceUser.readByLogin(login))) {
            return serviceUser.readByLogin(login);
        } else if (!Objects.isNull(serviceDoctors.readByLogin(login))) {
            return serviceDoctors.readByLogin(login);
        }
        return null;
    }
}
