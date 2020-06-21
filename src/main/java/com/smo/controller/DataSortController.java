package com.smo.controller;

import com.smo.entite.DataPoints;
import com.smo.service.DataPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sort")
public class DataSortController {

    @Autowired
    private DataPointsService dataPointsService;

    @GetMapping()
    public String stringMVC(ModelMap modelMap) {
        List<List<Map<Object, Object>>> dataList = dataPointsService.getDataPoints();
        modelMap.addAttribute("dataList", dataList);
//      modelMap.addAttribute("limit", limit);
        return "sort";
    }

//    @GetMapping("/limit/{value}")
//    public String changeArray(@PathVariable int value) {
//        dataPointsService.setLimit(value);
//        return "sort";
//    }

}
