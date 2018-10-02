package com.spring.version.services;

import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;
import com.spring.version.services.BikeServicesInt;
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
public class BikeDataServicesImplTest {

    @Autowired
    private BikeServicesInt bikeServicesInt;

    @Test
     public void addDataTest() {
        try {
            OrderModel ordeData = exampleForSaveData();
            bikeServicesInt.addBike(ordeData);
            Assert.assertEquals("Test-NameD",ordeData.getUserData().getName());
        }catch(Exception e){
            Assert.fail();
        }

    }

    @Test
    public void updateDataBike() {
        try {
            OrderModel ordeData = exampleForSaveData();
            ordeData.setCountBike(10);
            ordeData.setAddress("Update-TestAddres");
            OrderModel orderUpdatetest = bikeServicesInt.updateDataBike(ordeData);
            Assert.assertEquals("Update-TestAddres",orderUpdatetest.getAddress());
        }catch (Exception e){
            Logger.getLogger("test-update" + e.getMessage());
            Assert.fail();
        }

    }
    @Test
    public void getOrderByUser(){
        try {
            OrderModel ordeData = exampleForSaveData();
            List<OrderModel> dataTest =  bikeServicesInt.getOrderByUser(ordeData.getUserData());
            Assert.assertNotNull(dataTest);
        }catch (Exception e){
            Assert.fail();
        }

    }

    @Test
    public void getDataByOrderBikeTest(){
        try {
            OrderModel tesData = bikeServicesInt.getDataByOrderBike(28);
            Assert.assertNotNull(tesData);
        }catch (Exception e){
            Assert.fail();
        }

    }

    private OrderModel exampleForSaveData() {
        OrderModel orderdata = new OrderModel();
        UserData userData = new UserData();
        /*User */
        userData.setName("Test-NameD");
        userData.setDni("DNI-TEST");
        userData.setEmail("Test-UserName");
        userData.setPassword("password-Test");
        userData.setRolUser("ROLE-Admin");
        userData.setStatus("Active");

        /* All Order Test*/
        orderdata.setAddress("Test-Adrress1");
        orderdata.setCountBike(5);
        orderdata.setTotalDays(15);
        orderdata.setTotalPay(150.20);
        orderdata.setUserData(userData);
        System.out.print("Data Insert--" + orderdata.toString());
        return orderdata;
    }
}