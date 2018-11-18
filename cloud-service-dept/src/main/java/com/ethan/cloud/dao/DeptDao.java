package com.ethan.cloud.dao;

import com.ethan.cloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findOneById(Long id);

    List<Dept> findAll();
}
