package com.spring.version.services;

import com.spring.version.model.StoryData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BikeServicesInt {

     void addBike(StoryData bikeData);

     List<StoryData> getAllEmployees();

     void deleteDataBike(Integer bikeId);

     StoryData getDataByBike(int bikeId);

     StoryData updateDataBike(StoryData bikeData);
}
