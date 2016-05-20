package com.example.controller;

import com.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by 1 on 16/5/20.
 */

@Controller
@RequestMapping("main")
public class MainController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("movies", movieService.findAll());
        return "main/index";
    }
}
