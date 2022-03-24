package com.kj.mapper;

import com.kj.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    // 查询全部员工信息
    List<Employee> queryEmployeeList();

    // 通过id查询员工
    Employee queryEmployeeByID(int id);

    // 通过id删除员工
    int deleteEmployeeByID(int id);

    // 增加员工
    int addEmployee(Employee employee);

    // 修改员工
    int updateEmployee(Employee employee);
}
