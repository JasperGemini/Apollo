package com.nepxion.apollo.data;

/**
 * <p>Title: Nepxion Apollo</p>
 * <p>Description: Nepxion Apollo For Spring Cloud</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Date;

public class UserFactory {
    public static User createUser1() {
        User user = new User();
        user.setId("10000");
        user.setName("Zhangsan");
        user.setAge(30);
        user.setBirthday(new Date());
        user.setPhone("021-12345678");
        user.setEmail("Zhangsan@qq.com");
        user.setAddress("Shanghai");

        return user;
    }

    public static User createUser2() {
        User user = new User();
        user.setId("20000");
        user.setName("Lisi");
        user.setAge(40);
        user.setBirthday(new Date());
        user.setPhone("010-87654321");
        user.setEmail("Lisi@sina.com");
        user.setAddress("Beijing");

        return user;
    }
}