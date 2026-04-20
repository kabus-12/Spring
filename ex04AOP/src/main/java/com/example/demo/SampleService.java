package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.advice.PrintExecutionTime;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SampleService {

	@Autowired SampleMapper sampleMapper;
	
	@Transactional
	public void insert(String title) { //6글자
		sampleMapper.sample2(title); //50 
		sampleMapper.sample(title);  //5  //error 가 나면 둘모두 롤백해야함
	}
	
	//@PrintExecutionTime //AOP 어드바이스 실행
	public void test1(String name) {
		log.info("test1 실행");
	}
	
	
	public void test2() {
		log.info("test2 실행");
	}
}
