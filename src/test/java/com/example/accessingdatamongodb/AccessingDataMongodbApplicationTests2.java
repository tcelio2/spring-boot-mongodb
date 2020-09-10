package com.example.accessingdatamongodb;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.accessingdatamongodb.entity.Customer;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import com.example.accessingdatamongodb.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AccessingDataMongodbApplicationTests2 {

	
	@Autowired
	CustomerService service;
	
	
	@MockBean
	CustomerRepository repository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void teste1() {
		Customer c1 = new Customer("1","Thiago","Pereira");
		Customer c2 = new Customer("2","Simone","Carmelita");
		Customer c3 = new Customer("3","Maria Clara","Almeida");
		List<Customer> l = new ArrayList<>();
		l.add(c1); l.add(c2); l.add(c3);
		Mockito.when(repository.findAll()).thenReturn(l);
		
		assertEquals(service.getAllCustomers(), l);
	}
	
}
