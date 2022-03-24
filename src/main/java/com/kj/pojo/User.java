package com.kj.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 用户表
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User实体类")
public class User {
    @ApiModelProperty("用户ID")
    private Integer id;
    @ApiModelProperty("用户姓名")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("用户权限组")
    private String perms;
}
