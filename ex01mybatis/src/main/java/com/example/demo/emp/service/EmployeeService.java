package com.example.demo.emp.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.PageInfo;

//@Component + 프록시 (대행)클래스 구현
@Mapper
public interface EmployeeService {
	PageInfo<Object> selectAll(EmployeeVO emp,int pageNum);
	EmployeeVO selectOne(int empid);
	int insert(EmployeeVO emp);
	int update(EmployeeVO emp);
	int delete(int id);
}
