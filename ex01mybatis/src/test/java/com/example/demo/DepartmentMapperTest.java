package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.DepartmentMapper;
import com.example.demo.emp.service.DepartmentVO;

@SpringBootTest
public class DepartmentMapperTest {

	
	@Autowired
	DepartmentMapper mapper;
	
	//@Test
	public void selectOne() {
		DepartmentVO dept = mapper.selectOne(500);
		System.out.println(dept.getDepartmentName());
	}
	
	@Test
	public void selectAll() {
		DepartmentVO param = new DepartmentVO();
		param.setDepartmentName("Training");
		List<DepartmentVO> list = mapper.selectAll(param);
		for(DepartmentVO depa : list ) {
			System.out.println(depa.getDepartmentName());
		}
	}
}
