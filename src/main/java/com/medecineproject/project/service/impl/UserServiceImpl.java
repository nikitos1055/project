package com.medecineproject.project.service.impl;

import com.medecineproject.project.model.User;
import com.medecineproject.project.repository.UserRepository;
import com.medecineproject.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository rep;

    @Override
    public User save(User user) {
        return rep.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return rep.findById(id);
    }

    @Override
    public List<User> findAll() {
        return rep.findAll();
    }

    @Override
    public User update(User user) {
        return rep.save(user);
    }

    @Override
    public void deleteById(long id) {
        rep.deleteById(id);
    }

    @Override
    public User readByLogin(String login) {
        return rep.readByLogin(login);
    }

    @Override
    public boolean isExists(long id) {
        return rep.existsById(id);
    }
}
