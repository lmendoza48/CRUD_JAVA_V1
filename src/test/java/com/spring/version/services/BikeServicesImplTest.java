package com.spring.version.services;

import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@Transactional
public class BikeServicesImplTest {

    @Autowired
    private BikeServicesInt bikeServicesInt;

    @Test
     public void addDataTest() {
        OrderModel orderdata = new OrderModel();
        UserData userData = new UserData();
        try{
            /*User */
            userData.setName("Test-Name");
            userData.setDni("DNI-TEST");
            userData.setEmail("Test-UserName");
            userData.setPassword("password-Test");
            userData.setRolUser("ROLE-Admin");
            userData.setStatus("Active");

            /* All Order Test*/
            orderdata.setAddress("Test-Adrress1");
            orderdata.setCountBike(5);
            orderdata.setTotalDays(15);
            orderdata.setTotalPay((Double) 150.20);
            orderdata.setUserData(userData);

            bikeServicesInt.addBike(orderdata);

            System.out.print("Data Insert--" + orderdata.toString());

        }catch (Exception e){
            Logger.getLogger(e.getMessage());
            Assert.fail();
        }
    }

   /* @Test
     void getAllEmployees() {
    }

    @Test
     void deleteDataBike() {
    }

    @Test
     void getDataByBike() {
    }

    @Test
     void updateDataBike() {
    }*/
}