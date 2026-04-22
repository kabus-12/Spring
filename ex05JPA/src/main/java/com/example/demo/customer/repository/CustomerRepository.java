package com.example.demo.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	//나이 범위에 포함되는 회원
	public List<Customer> findByAgeBetween(Integer min, Integer max);
	
	//이름을 포함하는고객 조회
	
	public List<Customer> findByNameContaining(String name);
	
	
	//JPQL
	@Query(value = "select c from Customer c where name=:name and age > :age")
	public List<Customer> findByName(@Param("name") String name,@Param("age") int age);
	
	
	@Query(value = "select c.name from Customer c")
	public List<String> getName();
	
	@Query(value = "select c.name,c.age from Customer c")
	public List<Object[]> getNameAge();
}
