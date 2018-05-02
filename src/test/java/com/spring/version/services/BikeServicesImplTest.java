package com.spring.version.services;

import com.spring.version.model.StoryData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class BikeServicesImplTest {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private BikeServicesInt bikeServicesInt;

    @Test
     public void addBike() {
        StoryData storyData = new StoryData();
        try{
            storyData.setNameUser("TestName");
            storyData.setAddress("Test-Address");
            storyData.setDniPassport("Test-DNIorPassport");
            storyData.setEmail("Test-Email");
            storyData.setCountBike((long) 5);
            storyData.setTotalCount((long) 150);
            storyData.setTotalDay((long) 15);

            bikeServicesInt.addBike(storyData);

            System.out.print("Data Insert--" + storyData);

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