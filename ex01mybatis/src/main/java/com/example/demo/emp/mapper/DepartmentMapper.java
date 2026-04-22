package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.service.DepartmentVO;

@Mapper
public interface DepartmentMapper {
	List<DepartmentVO> selectAll(DepartmentVO emp);
	DepartmentVO selectOne(int deid);
	int delete(int id);
	int update(DepartmentVO emp);
	int insert(DepartmentVO emp);
	
}
