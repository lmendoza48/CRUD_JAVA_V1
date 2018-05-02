package com.spring.version.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Here Al Data for View connect my DataBases
 */
@Entity
@Table(name = "bikeData")
public class StoryData implements Serializable {
    private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nameUser;

    @Column
    private String dniPassport;

    @Column
    private String email;

    @Column
    private Long countBike;

    @Column
    private String address;

    @Column
    private Long totalDay;

    @Column
    private Long totalCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getDniPassport() {
        return dniPassport;
    }

    public void setDniPassport(String dniPassport) {
        this.dniPassport = dniPassport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCountBike() {
        return countBike;
    }

    public void setCountBike(Long countBike) {
        this.countBike = countBike;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Long totalDay) {
        this.totalDay = totalDay;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
