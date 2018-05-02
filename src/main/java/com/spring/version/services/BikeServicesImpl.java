package com.spring.version.services;

import com.spring.version.DAO.BikeDataDAO;
import com.spring.version.model.StoryData;
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

    @Override
    @Transactional
    public void addBike(StoryData bikeData) {
        allDatabike.addBikeData(bikeData);
    }

    @Override
    @Transactional
    public List<StoryData> getAllEmployees() {
        return allDatabike.getAllEmployees();
    }

    @Override
    @Transactional
    public void deleteDataBike(Integer bikeId) {
        allDatabike.deleteDataByBike(bikeId);
    }

    @Override
    public StoryData getDataByBike(int bikeId) {
        StoryData data = allDatabike.getEmployee(bikeId);
        return data;
    }

    @Override
    public StoryData updateDataBike(StoryData bikeData) {
        return allDatabike.updateEmployee(bikeData);
    }

}
