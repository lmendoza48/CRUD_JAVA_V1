package com.spring.version.DAO;

import com.spring.version.model.UserData;

import java.util.List;

public interface UserDataDAOint {
    UserData getUserDataByUsername(String userData);
    UserData getUserDataByIdUser(String idUser);
    void saveUser(UserData userData);
}
