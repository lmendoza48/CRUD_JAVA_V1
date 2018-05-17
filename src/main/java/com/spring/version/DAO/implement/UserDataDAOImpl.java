package com.spring.version.DAO.implement;

import com.spring.version.DAO.UserDataDAOint;
import com.spring.version.model.UserData;
import com.spring.version.services.UserDataServicesInt;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataDAOImpl implements UserDataDAOint {

    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public UserData getUserDataByUsername(String userData) {
       return (UserData) sessionFactory.getCurrentSession()
               .createQuery("from UserData where email = ?").setParameter(0,userData).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public UserData getUserDataByIdUser(String idUser) {

        return (UserData) sessionFactory.getCurrentSession()
                .createQuery("from UserData where idUser = ?").setParameter(0,Integer.parseInt(idUser)).uniqueResult();
    }

    public void saveUser(UserData userData) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(userData);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void deleteUser(Long userData) {
        //here code for delete or inactive user
    }
}
