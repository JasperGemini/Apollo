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

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 对apollo-service服务的绑定和关联，达到以本地接口方式调用远程接口的目的
@FeignClient(value = "apollo-service", fallback = EurekaReferenceFeignClientFallback.class)
public interface EurekaReferenceFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    String getUser(@RequestParam(value = "name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}