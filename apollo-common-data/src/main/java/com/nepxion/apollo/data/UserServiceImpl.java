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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private List<User> users;

    public UserServiceImpl() {
        users = new ArrayList<User>();
        users.add(UserFactory.createUser1());
        users.add(UserFactory.createUser2());
    }

    @Override
    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                LOG.info("服务端-返回处理结果：返回值=User name={}, address={}, phone={}", user.getName(), user.getAddress(), user.getPhone());
                return user;
            }
        }

        return null;
    }

    @Override
    public User getUser(String name, int age) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getAge() == age) {
                LOG.info("服务端-返回处理结果：返回值=User name={}, address={}, phone={}", user.getName(), user.getAddress(), user.getPhone());
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> getUsers() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void refreshUsers() {
        LOG.info("服务端-不返回处理结果");

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}