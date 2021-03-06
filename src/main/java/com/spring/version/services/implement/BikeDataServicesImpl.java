package com.spring.version.services.implement;

import com.spring.version.DAO.BikeDataDAO;
import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;
import com.spring.version.services.BikeServicesInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class for consult all data in data base
 */
@Service
@Transactional
public class BikeDataServicesImpl implements BikeServicesInt {

    @Autowired
    private BikeDataDAO allDatabike;

    @Transactional
    public void addBike(OrderModel orderModel) {
        allDatabike.addBikeData(orderModel);
    }

    @Transactional
    public void deleteDataByBike(Integer orderId) {
        allDatabike.deleteDataByBike(orderId);
    }


    public OrderModel updateDataBike(OrderModel orderModel) {
        return allDatabike.updateEmployee(orderModel);
    }

    /**
     * get data Order by bikeId
     * @param orderId
     * @return Order for Update
     */
    @Transactional(readOnly = true)
    public OrderModel getDataByOrderBike(int orderId) {
        return allDatabike.getDataByOrderOfBike(orderId);
    }

    /**
     * All data by User...
     * @param userLogin
     * @return ordenes del usuario logueado
     */
    @Transactional(readOnly = true)
    public List<OrderModel> getOrderByUser(UserData userLogin) {
        return allDatabike.getOrderByUser(userLogin);
    }
}
