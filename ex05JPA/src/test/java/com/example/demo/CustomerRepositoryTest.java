package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.customer.repository.Address;
import com.example.demo.customer.repository.AddressRepository;
import com.example.demo.customer.repository.Customer;
import com.example.demo.customer.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AddressRepository addressRepository;

	@BeforeEach
	public void init() {
		addressRepository.deleteAll();
		customerRepository.deleteAll();

		customerRepository.save(Customer.builder().name("홍길동").phone("011").age(15).build());
		customerRepository.save(Customer.builder().name("김길동").phone("012").age(25).build());
		customerRepository.save(Customer.builder().name("박길동").phone("013").age(35).build());
		customerRepository.save(Customer.builder().name("배길동").phone("014").age(20).build());
	}

	@Test
	void onetoOneAddressOwnerTest() {
		// given(준비)
		Customer customerentity = Customer.builder().name("이길동").phone("022").build();
		customerRepository.save(customerentity);
		Address addressEntity = Address.builder().zipcode("04411").address("대구").customer(customerentity).build();
		addressRepository.save(addressEntity);
		// when(실행)
		Address address = addressRepository.findById(addressEntity.getId()).get();
		log.info(address.getZipcode() + ":" + address.getCustomer().getName());
		// then(검증)
		assertEquals("이길동", address.getCustomer().getName());
	}

	// @Test
	public void getname() {
		List<Object[]> list = customerRepository.getNameAge();
		list.stream().forEach(a -> System.out.println());
	}

	// @Test
	public void name() {
		List<Customer> list = customerRepository.findByName("홍길동", 15);

//		assertEquals(list.size(), 2);
	}

	// @Test
	public void nameSearch() {
		List<Customer> list = customerRepository.findByNameContaining("홍길동");

		assertEquals(list.size(), 1);
	}

	@Rollback
	// @Transactional
	// @Test
	public void ageBetween() {
		// given 샘플 등록

		// when
		List<Customer> list = customerRepository.findByAgeBetween(20, 30);

		// then
		assertEquals(list.size(), 2);
	}

	// @Rollback
	// @Transactional
	// @Test
	public void insert() {
		// given
		Customer customer = Customer.builder().name("홍길동").phone("011").build();

		// when
		Customer result = customerRepository.save(customer);

		// then
		Customer cust = customerRepository.findById(result.getId()).get();
		assertEquals(cust.getName(), "홍길동");

	}

	// @Test
	public void update() {
		// given
		Customer cust = Customer.builder().id(1L).name("김기자").phone("012").build();
		// when

		customerRepository.save(cust);
		// then
		assertEquals(customerRepository.findById(1L).get().getName(), "김기자");

	}

	// @Test
	public void delete() {
		// given
		Customer cust = customerRepository.findById(2L).get();
		// when
		customerRepository.delete(cust);
		// then
//		assertTrue(customerRepository.findById(1L).isEmpty());
	}
}
