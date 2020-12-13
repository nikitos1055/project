package com.medecineproject.project.service;

import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findById(long id);

    List<User> findAll();

    User update(User user);

    void deleteById(long id);

    User readByLogin(String login);

    boolean isExists(long id);

    User readById(long id);
}
