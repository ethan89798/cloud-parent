package com.ethan.cloud.service.impl;

import com.ethan.cloud.dao.DeptDao;
import com.ethan.cloud.entities.Dept;
import com.ethan.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept findOneById(Long id) {
        return deptDao.findOneById(id);
    }

    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
