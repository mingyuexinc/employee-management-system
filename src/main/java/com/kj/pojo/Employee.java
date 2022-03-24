package com.kj.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 员工表
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Employee实体类")
public class Employee {
    @ApiModelProperty("员工ID")
    private Integer id;
    @ApiModelProperty("员工姓名")
    private String name;
    @ApiModelProperty("员工邮箱")
    private String email;
    @ApiModelProperty("员工性别")
    private Integer gender; // 0,1
    @ApiModelProperty("员工所属部门ID")
    private int departmentId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("员工生日")
    private Date birth;
    @ApiModelProperty("员工所属部门")
    private Department department;
}
