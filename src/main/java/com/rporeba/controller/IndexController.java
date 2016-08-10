package com.rporeba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rporeba on 22.07.2016.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/task/", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

}

