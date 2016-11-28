package com.nepxion.apollo.reference;

/**
 * <p>Title: Nepxion Apollo</p>
 * <p>Description: Nepxion Apollo For Spring Cloud</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaReference3 {
    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discovery;

    // http://localhost:3334/discovery
    @RequestMapping("/discovery")
    public Object discovery() {
        ServiceInstance serviceInstance = loadBalancer.choose("apollo-service");

        System.out.println("serviceInstance=" + serviceInstance);

        return "Eureka ::: Spring Cloud Load Balance=" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
    }

    // http://localhost:3334/all
    @RequestMapping("/all")
    public Object all() {
        List<String> list = discovery.getServices();

        System.out.println("list=" + list);

        return "Eureka ::: Spring Cloud Discovery List Size=" + list.size();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaReference3.class).web(true).run(args);
    }
}