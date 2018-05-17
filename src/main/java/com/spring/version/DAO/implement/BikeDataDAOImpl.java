package com.spring.version.DAO.implement;

import com.spring.version.DAO.BikeDataDAO;
import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * All data in Data Base
 * Search all information in base data
 */
@Repository
public class BikeDataDAOImpl implements BikeDataDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * method save all Order
     * @param orderModel
     */
    public void addBikeData(OrderModel orderModel) {
        sessionFactory.getCurrentSession().saveOrUpdate(orderModel);
    }

    /**
     * method update order by user
     * @param orderModel
     * @return
     */
    public OrderModel updateEmployee(OrderModel orderModel) {
        sessionFactory.getCurrentSession().update(orderModel);
        return orderModel;
    }

    /**
     * method by delete order of User
     * @param bikeId
     */
    public void deleteDataByBike(Integer bikeId) {
        try {
            OrderModel bikeByID = getEmployee(bikeId);
            if (bikeByID != null){
                this.sessionFactory.getCurrentSession().delete(bikeByID);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    public List<OrderModel> getOrderByUser(UserData userDataList) {
        List<OrderModel> allData;
        try{
            allData =  sessionFactory.getCurrentSession().createQuery("From OrderModel where userData = ? ").setParameter(0,userDataList).list();
        }catch (Exception e){
            e.getMessage();
            return new ArrayList<OrderModel>();
        }
        return allData;
    }

    /**
     * metodo que optiene por id los datos NOTA: el metodo no puede ser Override
     * @param bikeId
     * @return
     */
    public OrderModel getEmployee(int bikeId) {
        return (OrderModel) sessionFactory.getCurrentSession().get(OrderModel.class,bikeId);
    }

    /* @SuppressWarnings("unchecked")
    public List<OrderModel> getAllEmployees() {
        List<OrderModel> allData;
        try{
            allData =  sessionFactory.getCurrentSession().createQuery("From OrderModel").list();
        }catch (Exception e){
            e.getMessage();
            return new ArrayList<OrderModel>();
        }
        return allData;
    }*/
}
