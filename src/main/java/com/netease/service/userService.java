package com.netease.service;

import com.netease.entity.user;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanchuang on 2018-2-25.
 */
public interface userService {

    public void save(user user);
    public List<user> getUsers(Integer id);
}

