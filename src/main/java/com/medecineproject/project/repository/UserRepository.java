package com.medecineproject.project.repository;

import com.medecineproject.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,
        CrudRepository<User, Long> {

    User readByLogin(String login);

    User readById(long id);
}
