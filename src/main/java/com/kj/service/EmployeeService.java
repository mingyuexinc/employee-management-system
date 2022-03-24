package com.kj.service;

import com.kj.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    // 查询全部员工信息
    List<Employee> queryEmployeeList();

    // 通过id查询员工
    Employee queryEmployeeByID(int id);

    // 通过id删除员工
    int deleteEmployeeByID(int id);

    // 修改员工
    int updateEmployee(Employee employee);

    // 增加员工
    int addEmployee(Employee employee);
}
