package com.spring.version.services;

import com.spring.version.model.UserData;

import java.util.List;

public interface UserDataServicesInt {

    void saveUser(UserData userData);
    void deleteUser(Long Idlogin);
    UserData getUserDataByIdUser(String IdUser);
}
