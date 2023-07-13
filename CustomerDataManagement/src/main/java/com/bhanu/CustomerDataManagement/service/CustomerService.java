package com.bhanu.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bhanu.CustomerDataManagement.dto.CustomerDto;
import com.bhanu.CustomerDataManagement.dto.ResponseStructure;
import com.bhanu.CustomerDataManagement.entity.Customer;
import com.bhanu.CustomerDataManagement.repository.CustomerDao;
import com.bhanu.CustomerDataManagement.repository.CustomerRepository;

@Service 
public class CustomerService 
{
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseStructure<Customer> saveCustomer(CustomerDto customerdto)
	{
		Customer customer = new Customer(customerdto);
		Customer cus = customerDao.saveCustomer(customer);
		ResponseStructure<Customer> rs = new ResponseStructure<>();
		rs.setData(cus);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("customer data saved successfully");
		rs.setTimeStamp(LocalDateTime.now());
		return rs;
		
	}
	
	public ResponseStructure<Customer> updateCustomer(Customer customer)
	{
		 Customer c = customerDao.saveCustomer(customer);
		 ResponseStructure r=new ResponseStructure<>();
		 r.setData(c);
		 r.setStatusCode(HttpStatus.ACCEPTED.value());
		 r.setTimeStamp(LocalDateTime.now());
		 r.setMessage(HttpStatus.ACCEPTED.name());
		 return r;
		 
	}
	
	public ResponseStructure<List<Customer>> getAllCustomerData()
	{
		 List<Customer> l = customerDao.getAllCustomerData();
		 ResponseStructure <List<Customer>> r=new ResponseStructure<>();
		 if(l.size()!=0)
		 { 
			 r.setData(l);
			 r.setStatusCode(HttpStatus.FOUND.value());
			 r.setTimeStamp(LocalDateTime.now());
			 r.setMessage("Customers entry found in database");
		 }
		 else
		 {
			 r.setStatusCode(HttpStatus.NOT_FOUND.value());
			 r.setData(null);
			 r.setTimeStamp(LocalDateTime.now());
			 r.setMessage("no customers entry found in database");
		 }
		 return r;
		 
	}
	
	public Customer getDataById(int id)
	{
		return customerDao.getCustomerDataById(id);
	}
	
	public Customer deleteCustomerDataById(int id)
	{
		return customerDao.deleteCustomerDataById(id);
	}
	
	public List<Customer> findByName(String name)
	{
		return customerDao.getCustomerByname(name);
	}
	
	 public List<Customer> validateCustomer(String name,String email)
	  {
		 return customerDao.validateCustomer(name, email);
	  }
}
