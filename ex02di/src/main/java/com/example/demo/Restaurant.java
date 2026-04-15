package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;



//@Scope("prototype")
//@Lazy //지연 최초사용될때
@Component
@Getter
public class Restaurant {
	//@Autowired
	private Chef chef;

	public Restaurant(Chef chef) {
		this.chef = chef;
		System.out.println("레스토랑 생성");
	}

	
	

	
	
	
}
