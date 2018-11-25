package com.ethan.cloud.feign.service;

import com.ethan.cloud.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 *
 */
@FeignClient(value = "SERVICE-DEPT")
public interface DeptClientService {

    @PostMapping("/dept/add")
    boolean add(Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    List<Dept> list();
}
