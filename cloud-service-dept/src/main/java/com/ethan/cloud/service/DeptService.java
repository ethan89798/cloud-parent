package com.ethan.cloud.service;

import com.ethan.cloud.entities.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept findOneById(Long id);

    List<Dept> findAll();
}
