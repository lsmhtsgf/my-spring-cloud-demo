package com.posp.controller;

import com.posp.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hello")
    public String sayHello(@RequestParam String name) {
        return schedualServiceHi.hello(name);
    }
}
