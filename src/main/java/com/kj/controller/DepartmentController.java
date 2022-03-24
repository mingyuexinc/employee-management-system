package com.kj.controller;

import com.kj.pojo.Department;
import com.kj.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("查询全部部门接口")
    @GetMapping("/dep/list")
    public String toDepartmentList(Model model){
        Collection<Department> departments = departmentService.queryDepartmentList();
        model.addAttribute("deps",departments);
        return "dep/list";
    }

    @GetMapping("/dep/add")
    public String toAddDepartment(Department department){
        return "dep/add";
    }

    @ApiOperation("添加部门接口")
    @PostMapping("/dep/add")
    public String addDepartment(Department department){
        departmentService.addDepartment(department);
        return "redirect:/dep/list";
    }

    @GetMapping("/dep/update/{did}")
    public String toUpdate(@PathVariable("did") int did,Model model){
        Department department = departmentService.queryDepartmentByID(did);
        model.addAttribute("dep",department);
        return "dep/update";
    }

    @ApiOperation("修改部门信息接口")
    @PostMapping("/dep/update")
    public String updateDepartment(Department department){
        departmentService.updateDepartment(department);
        return "redirect:/dep/list";
    }

    @ApiOperation("删除部门接口")
    @GetMapping("/dep/delete/{did}")
    public String delete(@PathVariable("did") int did){
        departmentService.deleteDepartment(did);
        return "redirect:/dep/list";
    }

}
