package com.netease.shopping.service;

import com.netease.shopping.entity.User;

import java.util.List;

/**
 * Created by yuanchuang on 2018-2-25.
 */
public interface UserService {

    public void save(User user);
    public List<User> getUsers(Integer id);
    public User getUsersByName(String username);
    public boolean register(User user);
}

