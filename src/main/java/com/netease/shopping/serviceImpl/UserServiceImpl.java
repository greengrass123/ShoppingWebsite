package com.netease.shopping.serviceImpl;

import com.netease.shopping.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netease.shopping.service.UserService;
import com.netease.shopping.dao.mapper.UserMapper;

import java.util.List;

/**
 * Created by yuanchuang on 2018-2-25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    public void save(User User) {
        userDao.save(User);
    }
    public List<User> getUsers(Integer id){
        List<User> Users =userDao.getUsers(id);
        return Users;
    }
    public User getUsersByName(String username){
        List<User> Users =userDao.getUsersByName(username);
        if(Users.isEmpty()){
            return null;
        }

        return Users.get(0);
    }

    public boolean register(User user) {
        User registerUser=getUsersByName(user.getUserName());
        if(registerUser==null){
            return false;
        }
        if(registerUser.getUserName().equals(user.getUserName())&&registerUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
