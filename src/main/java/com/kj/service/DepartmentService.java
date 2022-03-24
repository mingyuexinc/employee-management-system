package com.kj.service;

import com.kj.pojo.Department;

import java.util.List;

public interface DepartmentService {
    // 查出所有部门的信息
    List<Department> queryDepartmentList();

    // 通过id查询部门
    Department queryDepartmentByID(int id);

    // 添加部门信息
    int addDepartment(Department department);

    // 修改部门信息
    int updateDepartment(Department department);

    // 删除部门信息
    int deleteDepartment(int did);
}
