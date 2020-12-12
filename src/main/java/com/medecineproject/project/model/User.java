package com.medecineproject.project.model;

import com.medecineproject.project.model.enums.Role;
import com.medecineproject.project.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User extends LoginData {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private long id;

    @Getter
    @Setter
    @Column(name = "user_name")
    private String name;

    @Getter
    @Setter
    @Column(name = "user_surname")
    private String surname;

    @Getter
    @Setter
    @Column(name = "user_role")
    private Role role = Role.USER;

    @Getter
    @Setter
    @Column(name = "user_login", unique = true, nullable = false)
    private String login;

    @Getter
    @Setter
    @Column(name = "user_password", nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name = "status")
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Meeting> meetings;


    public User(String name, String surname, String login, String password) {
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
}
