package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
	List<EmployeeVO> selectAll(EmployeeVO emp);
	EmployeeVO selectOne(int empid);
	int insert(EmployeeVO emp);
	int update(EmployeeVO emp);
	int delete(int id);
}
