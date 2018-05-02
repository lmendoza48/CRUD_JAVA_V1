package com.spring.version.DAO;

import com.spring.version.model.StoryData;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BikeDataDAO {

    void addBikeData(StoryData bike);

    List<StoryData> getAllEmployees();

    void deleteDataByBike(Integer bikeId);

    StoryData updateEmployee(StoryData bikeAll);

    StoryData getEmployee(int bikeId);
}
