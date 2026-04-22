package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.service.Ex01VO;

@Mapper
public interface Ex01Mapper {
	List<Ex01VO> getList(Ex01VO vo);
	Ex01VO read(int no);
	int insert(Ex01VO vo);
}
