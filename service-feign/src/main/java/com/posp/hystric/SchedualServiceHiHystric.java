package com.posp.hystric;

import com.posp.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
    @Override
    public String hello(String name) {
        return "hi,"+name+",sorry feign";
    }
}
