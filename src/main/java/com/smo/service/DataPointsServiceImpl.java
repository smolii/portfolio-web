package com.smo.service;

import com.smo.dao.DataPointsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DataPointsServiceImpl implements DataPointsService {

    private DataPointsDao dataPointsDao;

    @Autowired
    public void setDataPointsDao(DataPointsDao dataPointsDao) {
        this.dataPointsDao = dataPointsDao;
    }

    @Override
    public List<List<Map<Object, Object>>> getDataPoints() {
        return dataPointsDao.getDataPoints();
    }

}
