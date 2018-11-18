package com.ethan.cloud.controller;

import com.ethan.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

    private static String REST_URL_PREFIX = "http://localhost:8081";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping("list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);

    }
}
