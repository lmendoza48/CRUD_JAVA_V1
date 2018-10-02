package com.spring.version.services;

import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;

import java.util.List;


public interface BikeServicesInt {

     void addBike(OrderModel orderData);

     OrderModel updateDataBike(OrderModel orderModel);

     List<OrderModel> getOrderByUser(UserData userDataList);

     void deleteDataByBike(Integer orderId);

     OrderModel getDataByOrderBike(int orderId);


}
