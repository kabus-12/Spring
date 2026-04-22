package com.example.demo.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.emp.mapper.DepartmentMapper;
import com.example.demo.emp.service.DepartmentService;
import com.example.demo.emp.service.DepartmentVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentMapper departmentMapper;
	
	@Override
	public List<DepartmentVO> selectAll(DepartmentVO emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentVO selectOne(int deid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DepartmentVO emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(DepartmentVO emp) {
		// TODO Auto-generated method stub
		return 0;
	}

}
