package com.medecineproject.project.model;

import com.medecineproject.project.model.enums.Role;
import com.medecineproject.project.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User extends LoginData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_role")
    private Role role = Role.USER;

    @Column(name = "user_login", unique = true, nullable = false)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "status")
    private Status status = Status.ACTIVE;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public User(long id, String name, String surname, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public User(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                role == user.role &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, role, login, password, status);
    }
}
