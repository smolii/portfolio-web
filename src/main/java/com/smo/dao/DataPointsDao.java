package com.smo.dao;

import java.util.List;
import java.util.Map;

public interface DataPointsDao {
      List<List<Map<Object, Object>>> getDataPoints();
}
