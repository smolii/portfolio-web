package com.smo.entite;

import java.util.*;

public class DataPoints {

    static Map<Object, Object> map = null;
    static List<List<Map<Object, Object>>> dataList = new ArrayList<>();
    static List<Map<Object, Object>> dataPoints = new ArrayList<>();

    public static void genRanData(){
        Random random = new Random();
        int limit = random.nextInt(100);
        int y = 100;
        System.out.println(limit);
        for (int i = 0; i < limit; i++) {
            y += random.nextInt(11)-5 ;
            System.out.println("x= " + i + " y= " + y);
            map = new HashMap<>();
            map.put("x", i);
            map.put("y", y);
            dataPoints.add(map);
        }
        dataList.add(dataPoints);
    }
    public static List<List<Map<Object, Object>>> getDataList() {
        genRanData();
        return dataList;
    }


}
