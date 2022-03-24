package com.kj.mapper;

import com.kj.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryEmployeeList() {
        return employeeMapper.queryEmployeeList();
    }

    @Override
    public Employee queryEmployeeByID(int id) {
        return employeeMapper.queryEmployeeByID(id);
    }

    @Override
    public int deleteEmployeeByID(int id) {
        return employeeMapper.deleteEmployeeByID(id);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }
}
