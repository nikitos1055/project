package com.medecineproject.project.controller;

import com.medecineproject.project.model.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
@RestController
public class LogoutController {
    @PostMapping("/logout")
    public ResponseEntity<Doctor> logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (!Objects.isNull(session)) session.invalidate();
        else return new ResponseEntity<>(HttpStatus.CONFLICT);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
