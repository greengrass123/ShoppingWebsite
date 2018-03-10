package com.netease.dao.mapper;

import com.netease.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuanchuang on 2018-2-25.
 */
@Repository
public interface UserMapper {
    public void save(User User);//没有使用
    public List<User> getUsers(Integer id);
    public List<User> getUsersByName(String username);
}
