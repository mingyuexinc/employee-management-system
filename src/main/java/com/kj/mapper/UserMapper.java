package com.kj.mapper;

import com.kj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 注解表示其为Mybatis的User类
@Mapper
@Repository
public interface UserMapper {
    // 查询全部用户的信息
    List<User> queryUserList();

    // 根据id查询用户
    User queryUserByID(int id);

    // 根据username查询用户
    User queryUserByName(String username);
}
