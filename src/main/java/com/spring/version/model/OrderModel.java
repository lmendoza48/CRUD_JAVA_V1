package com.spring.version.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="orderData")
public class OrderModel implements Serializable {
    private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrder;
    @Column
    private String address;
    @Column
    private int countBike;
    @Column
    private int totalDays;
    @Column
    private Double totalPay;

    @ManyToOne
    @JoinColumn(name="IdUser")
    private UserData userData;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountBike() {
        return countBike;
    }

    public void setCountBike(int countBike) {
        this.countBike = countBike;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Override
    public String toString(){
        return "OrderData {" +
                "idOrder=" + idOrder +
                ",address='" + address + '\'' +
                ",countBike='" + countBike + '\'' +
                ",totalDays='" + totalDays + '\'' +
                ",totalPay='" + totalPay + '\'' +
                '}';
    }
}
