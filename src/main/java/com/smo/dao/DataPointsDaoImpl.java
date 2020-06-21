package com.smo.dao;

import com.smo.entite.DataPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DataPointsDaoImpl implements DataPointsDao {

       @Override
    public List<List<Map<Object, Object>>> getDataPoints() {
        return DataPoints.getDataList();
    }
}
