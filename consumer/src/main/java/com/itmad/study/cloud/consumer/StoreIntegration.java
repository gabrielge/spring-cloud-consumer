package com.itmad.study.cloud.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Map;

/**
 * Created by Gabriel.Ge on 2017-03-08.
 */
//@Component
public class StoreIntegration {
    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        return null;
    }

    public Object defaultStores(Map<String, Object> parameters) {
         /* TODO something useful */
        ;
        return null;
    }
}
