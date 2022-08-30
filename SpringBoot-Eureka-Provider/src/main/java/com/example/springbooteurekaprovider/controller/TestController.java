package com.example.springbooteurekaprovider.controller;

import com.example.springbooteurekaprovider.dao.UserDao;
import com.example.springbooteurekaprovider.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:钟湘
 * @data: 20:26
 */

@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/eureka")
    public String query(){
       InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("EUREKA-PROVIDER-SERVICE",false);
//       List<ServiceInstance> instance=discoveryClient.getInstances("EUREKA-PROVIDER-SERVICE");
//        for (ServiceInstance instances:instance) {
//            String url="http://"+instances.getHost()+":"+instances.getPort();
//            System.out.println(url);
//        }
       return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/query/{id}")
    public User query2(@PathVariable("id") Integer id){
        System.out.println("服务一");
        return userDao.selectById(id);
    }
}
