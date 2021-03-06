package com.example.accessingdatamongodb;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.accessingdatamongodb.entity.Customer;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import com.example.accessingdatamongodb.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessingDataMongodbApplicationTests {

	
	@InjectMocks
	@Autowired
	CustomerService service;
	
	@Autowired
	CustomerRepository repository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		feedCustomers();
	}

	private void feedCustomers() {

		Customer c1 = new Customer("1","Thiago","Pereira");
		Customer c2 = new Customer("2","Simone","Carmelita");
		Customer c3 = new Customer("3","Maria Clara","Almeida");
		
		repository.save(c1);
		repository.save(c2);
		repository.save(c3);
		
	}
	
	@Test
	public void CustomerTest() {
		List<Customer> customerList = service.getAllCustomers();
		
		Assert.assertTrue(customerList.size() > 0);
		
	}
}
