package com.spring.version.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="userinfo")
public class UserData {
    private static final long serialVersionUID = -3465813074586302847L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    @Column
    private String name;

    @Column
    private String dni;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String rolUser;

    @Column
    private String status;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "UserData{" +
                "idUser=" + idUser +
                ", ussername='" + name + '\'' +
                ", ussername='" + dni + '\'' +
                ", ussername='" + email + '\'' +
                ", ussername='" + password + '\'' +
                ", ussername='" + rolUser + '\'' +
                ", rolUser='" + status + '\'' +
                '}';
    }
}
