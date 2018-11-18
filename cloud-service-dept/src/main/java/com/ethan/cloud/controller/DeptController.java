package com.ethan.cloud.controller;

import com.ethan.cloud.entities.Dept;
import com.ethan.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.findOneById(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.findAll();
    }

}
