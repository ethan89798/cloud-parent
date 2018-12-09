package com.ethan.cloud.controller;

import com.ethan.cloud.entities.Dept;
import com.ethan.cloud.feign.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/add")
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptClientService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptClientService.list();
    }
}
