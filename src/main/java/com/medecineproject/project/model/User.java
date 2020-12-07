package com.medecineproject.project.model;

import com.medecineproject.project.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User extends LoginData{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_role")
    private Role role = Role.USER;

    @Column(name = "user_login", unique = true, nullable = false)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "is_banned")
    private Boolean banned = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Meeting> meetings;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
