package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired CustomerRepository customerRepository;
	
	//@Rollback
	//@Transactional
	//@Test
	public void insert() {
		//given
		Customer customer = new Customer();
		customer.setName("김길동");
		customer.setPhone("012");
		//when
		Customer result = customerRepository.save(customer);
		
		//then
		Customer cust = customerRepository.findById(result.getId()).get();
		assertEquals(cust.getName(),"홍길동");
		
	}
	
	//@Test
	public void update() {
		//given
		Customer cust = customerRepository.findById(1L).get();
		//when
		cust.setName("김유신");
		customerRepository.save(cust);
		//then
		assertEquals(customerRepository.findById(1L).get().getName(),"김유신");
		
	}
	
	@Test
	public void delete() {
		//given
		Customer cust = customerRepository.findById(2L).get();
		//when
		customerRepository.delete(cust);
		//then
//		assertTrue(customerRepository.findById(1L).isEmpty());
	}
}
