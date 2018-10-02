package com.spring.version.DAO;

import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;

import java.util.List;

public interface BikeDataDAO {

    void addBikeData(OrderModel order);

    OrderModel updateEmployee(OrderModel orderData);

    List<OrderModel> getOrderByUser(UserData userDataList);

    void deleteDataByBike(Integer bikeId);

    OrderModel getDataByOrderOfBike(int bikeId);
}
