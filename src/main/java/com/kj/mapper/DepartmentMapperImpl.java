package com.kj.mapper;

import com.kj.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentMapperImpl implements DepartmentMapper{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> queryDepartmentList() {
        return departmentMapper.queryDepartmentList();
    }

    @Override
    public Department queryDepartmentByID(int id) {
        return departmentMapper.queryDepartmentByID(id);
    }

    @Override
    public int addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public int deleteDepartment(int did) {
        return departmentMapper.deleteDepartment(did);
    }
}
