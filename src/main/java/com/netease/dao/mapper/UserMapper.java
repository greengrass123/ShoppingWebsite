package com.netease.dao.mapper;

import com.netease.entity.user;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuanchuang on 2018-2-25.
 */
@Repository
public interface UserMapper {
    public void save(user user);
    public List<user> getUsers(Integer id);
}
