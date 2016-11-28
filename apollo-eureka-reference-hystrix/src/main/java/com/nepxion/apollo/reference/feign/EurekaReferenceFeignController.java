package com.nepxion.apollo.reference.feign;

/**
 * <p>Title: Nepxion Apollo</p>
 * <p>Description: Nepxion Apollo For Spring Cloud</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @email 1394997@qq.com
 * @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaReferenceFeignController {
    @Autowired
    private EurekaReferenceFeignClient feignClient;

    // http://localhost:3333/getUser2
    @RequestMapping(value = "/getUser2", method = RequestMethod.GET)
    public String getUser() {
        return feignClient.getUser("Zhangsan");
    }
    
    // Url=http://localhost:3333/add2
    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public Integer add() {
        return feignClient.add(10, 20);
    }
}