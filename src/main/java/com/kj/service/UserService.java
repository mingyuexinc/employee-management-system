package com.kj.service;

import com.kj.pojo.User;

import java.util.List;

public interface UserService {
    // 查询全部用户的信息
    List<User> queryUserList();

    // 根据id查询用户
    User queryUserByID(int id);

    // 根据username查询用户
    User queryUserByName(String username);
}
