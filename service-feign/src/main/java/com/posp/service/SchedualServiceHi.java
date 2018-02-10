package com.posp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hello")
public interface SchedualServiceHi {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
