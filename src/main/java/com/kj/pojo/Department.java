package com.kj.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Department实体类")
public class Department {
    @ApiModelProperty("部门ID")
    private Integer did;
    @ApiModelProperty("部门名称")
    private String departmentName;
}
