package com.spring.version.services;

import com.spring.version.model.UserData;
import com.spring.version.services.implement.UserDataServicesImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@Transactional
public class UserDataServicesImplTest {

    @Autowired
    private UserDataServicesInt userDataServicesint;

    @Test
    public void saveUserTest() {
        try {
            UserData dataMock = getDataMockUser();
            userDataServicesint.saveUser(dataMock);
            Assert.assertEquals("Test-Name",dataMock.getName());
        }catch(Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getUserDataByIdUserTest() {
        try {
            UserData  dataProof = userDataServicesint.getUserDataByIdUser("20");
            Assert.assertNotNull(dataProof);
        }catch(Exception e){
            Assert.fail();
        }

    }

    @Test
    public void getUserByEmail() {
        try {
            UserData  dataProof2 = userDataServicesint.getUserByEmail("lmendoza@aconcaguabs.com");
            Assert.assertNotNull(dataProof2);
        }catch(Exception e){
            Assert.fail();
        }
    }

    @Test
    public void loadUserByUsername() {
        try {
            UserDataServicesImpl dataMock = new UserDataServicesImpl();
            UserDetails userSecurity = dataMock.loadUserByUsername("lmendoza@aconcaguabs.com");
           // Assert.assertNotNull(userSecurity);
        }catch(Exception e){
            Assert.fail();
        }
    }

    private UserData getDataMockUser(){
        UserData modelData = new UserData();

        modelData.setEmail("Test_email@gmail.com");
        modelData.setRolUser("Test_Rol");
        modelData.setStatus("Active");
        modelData.setDni("96874521");
        modelData.setName("Test-Name");
        modelData.setIdUser(85);

        return modelData;
    }
}