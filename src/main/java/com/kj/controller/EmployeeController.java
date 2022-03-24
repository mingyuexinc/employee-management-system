package com.kj.controller;


import com.kj.pojo.Department;
import com.kj.pojo.Employee;
import com.kj.service.DepartmentService;
import com.kj.service.DepartmentServiceImpl;
import com.kj.service.EmployeeService;
import com.kj.service.EmployeeServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("查询全体员工员接口")
    @GetMapping("/emp/emps")
    public String list(Model model){
        // 获得所有的员工信息
        Collection<Employee> employees = employeeService.queryEmployeeList();
        // 返回前端
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp/add")
    public String toAddPage(Model model){
        // 查出所有部门的信息
        Collection<Department> departments = departmentService.queryDepartmentList();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @ApiOperation("添加员工接口")
    @PostMapping("/emp/add")
    public String addEmp(Employee employee){
        // 添加
        System.out.println("add=>"+employee);
        employeeService.addEmployee(employee);
        return "redirect:/emp/emps";
    }

    // 跳转到员工修改页面
    @GetMapping("/emp/update/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        // 查出原数据
        Employee employee = employeeService.queryEmployeeByID(id);
        model.addAttribute("emp",employee);
        // 查出所有部门的信息
        Collection<Department> departments = departmentService.queryDepartmentList();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @ApiOperation("修改员工信息接口")
    @PostMapping("/emp/update")
    public String updateEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emp/emps";
    }

    // 删除员工
    @ApiOperation("删除员工信息接口")
    @GetMapping("/emp/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeService.deleteEmployeeByID(id);
        return "redirect:/emp/emps";
    }
}
