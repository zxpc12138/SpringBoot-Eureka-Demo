package com.example.springbooteurekaconsume.controller;

import com.example.springbooteurekaconsume.dao.UserDao;
import com.example.springbooteurekaconsume.entiey.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author:钟湘
 * @data: 16:38
 */
@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/save")
    public void save(){
        User user=new User();
        user.setName("zhong");
        user.setAddr("湖南");
        userDao.insert(user);
    }

    @GetMapping("/query/{id}")
    public User query(@PathVariable("id") Integer id){
        return userDao.selectById(id);
    }

    @GetMapping("/query")
    public User query2(){
       return  restTemplate.getForObject("http://localhost:8081/query/1",User.class);
    }

    @GetMapping("/query3/{id}")
    @HystrixCommand(fallbackMethod = "myHystrix",commandProperties = {
      //错误的请求比例
      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "80"),
      //自我修复的活窗口时长
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")
    })
    public User query3(@PathVariable("id") Integer id ){
        System.out.println("有没有进来执行");
        return restTemplate.getForObject("http://EUREKA-PROVIDER-SERVICE/query/"+id,User.class);
    }

    public User myHystrix(Integer id){
        System.out.println("开启断路由");
        User user=new User();
        user.setName("1111111");
        return user;
    }

    @GetMapping("/text")
    public void text(){
       ServiceInstance serviceInstance=loadBalancerClient.choose("EUREKA-PROVIDER-SERVICE");
       System.out.println("调用的服务IP是："+serviceInstance.getHost()+"   :    "+serviceInstance.getPort()+"  :  "+serviceInstance.getServiceId());

       ServiceInstance serviceInstance2=loadBalancerClient.choose("EUREKA-PROVIDER-SERVICE2");
       System.out.println("调用的服务IP是："+serviceInstance2.getHost()+"   :    "+serviceInstance2.getPort()+"  :  "+serviceInstance2.getServiceId());
    }
}
