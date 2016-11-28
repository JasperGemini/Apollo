package com.nepxion.apollo.reference.ribbon;

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
public class EurekaReferenceRibbonController {
    @Autowired
    private EurekaReferenceRibbonService ribbonService;

//    // http://localhost:3333/getUser1
//    @RequestMapping(value = "/getUser1", method = RequestMethod.GET)
//    public String getUser() {
//        return ribbonService.getUser();
//    }
    
    // http://localhost:3333/add1
    @RequestMapping(value = "/add1", method = RequestMethod.GET)
    public String add() {
        return ribbonService.add();
    }
}