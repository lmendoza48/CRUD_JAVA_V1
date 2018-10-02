package com.spring.version.services;

import com.spring.version.model.UserData;

import java.util.List;

public interface UserDataServicesInt {
    void saveUser(UserData userData);
    UserData getUserDataByIdUser(String IdUser);
    UserData getUserByEmail(String email);
}
