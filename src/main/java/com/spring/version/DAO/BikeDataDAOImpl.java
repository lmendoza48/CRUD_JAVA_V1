package com.spring.version.DAO;

import com.spring.version.model.StoryData;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * All data in Data Base
 * Search all information in base data
 */
@Repository
public class BikeDataDAOImpl implements BikeDataDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBikeData(StoryData bike) {
        sessionFactory.getCurrentSession().saveOrUpdate(bike);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StoryData> getAllEmployees() {
        List<StoryData> allData;
        try{
            allData =  sessionFactory.getCurrentSession().createQuery("From StoryData").list();
        }catch (Exception e){
            e.getMessage();
            return new ArrayList<StoryData>();
        }
        return allData;
    }

    @Override
    public void deleteDataByBike(Integer bikeId) {
        try {
            StoryData bikeByID = getEmployee(bikeId);
            if (bikeByID != null){
                this.sessionFactory.getCurrentSession().delete(bikeByID);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public StoryData updateEmployee(StoryData bikeAll) {
        sessionFactory.getCurrentSession().update(bikeAll);
        return bikeAll;
    }

    /**
     * metodo que optiene por id los datos NOTA: el metodo no puede ser Override
     * @param bikeId
     * @return
     */
    public StoryData getEmployee(int bikeId) {
        return (StoryData) sessionFactory.getCurrentSession().get(StoryData.class,bikeId);
    }
}
