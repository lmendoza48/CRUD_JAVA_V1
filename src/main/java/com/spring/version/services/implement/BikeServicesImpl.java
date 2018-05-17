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
public class BikeServicesImpl implements BikeServicesInt {

    @Autowired
    private BikeDataDAO allDatabike;

    @Transactional
    public void addBike(OrderModel orderModel) {
        allDatabike.addBikeData(orderModel);
    }

    @Transactional
    public void deleteDataBike(Integer bikeId) {
        allDatabike.deleteDataByBike(bikeId);
    }


    public OrderModel updateDataBike(OrderModel orderModel) {
        return allDatabike.updateEmployee(orderModel);
    }

    @Transactional(readOnly = true)
    public OrderModel getDataByBike(int bikeId) {
        return allDatabike.getEmployee(bikeId);
    }
    @Transactional(readOnly = true)
    public List<OrderModel> getOrderByUser(UserData userDataList) {
        return allDatabike.getOrderByUser(userDataList);
    }
}
