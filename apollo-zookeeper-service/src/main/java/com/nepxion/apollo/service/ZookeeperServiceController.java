package com.nepxion.apollo.service;

/**
 * <p>Title: Nepxion Apollo</p>
 * <p>Description: Nepxion Apollo For Spring Cloud</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @email 1394997@qq.com
 * @version 1.0
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nepxion.apollo.data.User;
import com.nepxion.apollo.data.UserService;

@RestController
@ImportResource(locations = { "classpath*:applicationContext.xml" })
public class ZookeeperServiceController {
    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperServiceController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam String name) {
        return userService.getUser(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        String host = serviceInstance.getHost();
        String serviceId = serviceInstance.getServiceId();

        Integer result = a + b;

        LOG.info("/add, host:{}, service id:{}, result:{}", host, serviceId, result);

        return result;
    }
}