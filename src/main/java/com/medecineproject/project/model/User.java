package com.medecineproject.project.model;

import com.medecineproject.project.model.enums.Role;
import com.medecineproject.project.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Meeting> meetings;


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

    public void addMeeting(Meeting meeting){
//        meetings.add(meeting);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
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
