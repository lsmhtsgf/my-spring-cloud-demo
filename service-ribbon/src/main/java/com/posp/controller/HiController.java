package com.posp.controller;

import com.posp.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return hiService.hello(name);
//       return "Hello "+name+",you is using port:"+port;
    }

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return "hi " + name + ",you is using port:" + port;
    }
}
