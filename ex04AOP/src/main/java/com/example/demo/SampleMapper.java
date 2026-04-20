package com.example.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMapper {
	
	@Insert("insert into sample values (#{title})")
	void sample(String title);
	
	@Insert("insert into sample2 values (#{title})")
	void sample2(String title);
}
