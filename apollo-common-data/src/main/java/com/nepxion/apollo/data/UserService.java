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

import java.util.List;

public interface UserService {
    User getUser(String name);

    User getUser(String name, int age);

    List<User> getUsers();

    void refreshUsers();
}