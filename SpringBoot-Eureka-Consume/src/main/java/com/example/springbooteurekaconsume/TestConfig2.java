package com.example.springbooteurekaconsume;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author:钟湘
 * @data: 16:08
 */
@Configuration
public class TestConfig2 {

    @Bean
    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer2(Environment environment,
                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        //LoadBalancer自带的负载均衡算法只有两个：随机算法和轮询算法

        //选择随机算法
//         return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),name);

        //选择自定义负载均衡算法
        return new MyLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
    }
//    @Autowired
//    private IClientConfig iClientConfig;

//    @Bean
//    public IRule ribbonRule (){
//        return new RandomRule();
//    }
}
