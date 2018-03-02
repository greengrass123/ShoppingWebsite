package com.netease.serviceImpl;

import com.netease.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netease.service.userService;
import com.netease.dao.mapper.UserMapper;

import java.util.List;

/**
 * Created by yuanchuang on 2018-2-25.
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    private UserMapper userDao;

    public void save(user user) {
        userDao.save(user);
    }
    public List<user> getUsers(Integer id){
        List<user> users=userDao.getUsers(id);
        return users;
    }
}
