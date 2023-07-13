package com.bhanu.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhanu.CustomerDataManagement.dto.CustomerDto;
import com.bhanu.CustomerDataManagement.dto.ResponseStructure;
import com.bhanu.CustomerDataManagement.entity.Customer;
import com.bhanu.CustomerDataManagement.service.CustomerService;


@RestController
public class CustomerController 
{
	  @Autowired
	  private CustomerService customerService;
	  
//	  @PostMapping("/customer")
	  @PostMapping("/save")
	  public @ResponseBody ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDto customerDto)
	  {
		  return customerService.saveCustomer(customerDto);
	  }
	  
//	  @PutMapping("/customer")
	  @PutMapping("/update")
	  public @ResponseBody ResponseStructure updateCustomer(@RequestBody Customer customer)
	  {
		  return customerService.updateCustomer(customer);
	  }
	  
//	  @GetMapping("/customer")
	  @GetMapping("/getAllData")
	  public @ResponseBody ResponseStructure<List<Customer>> getalldata ()
	  {
		  return customerService.getAllCustomerData();
	  }
	  
//	  @GetMapping("/customer/{id}")
	  @GetMapping("/getDataByID/{id}")
	  public @ResponseBody Customer getDataByID(@PathVariable int id)
	  {
		  return customerService.getDataById(id);
	  }
	  
	  @DeleteMapping("/deleteCustomerDataById")
//	  @DeleteMapping("/customer")
	  public Customer deleteCustomerDataById(@RequestParam int id)
	  {
		  return customerService.deleteCustomerDataById(id);
	  }
	  
	  @GetMapping("/getCustomerByName/{name}")
	  public List<Customer> getCustomerByName(@PathVariable String name)
	  {
		  return customerService.findByName(name);
	  }
	  
	  @PostMapping("/getCustomerByName")
	  public List<Customer> validateCustomer(@RequestParam String name,@RequestParam String email)
	  {
		  return customerService.validateCustomer(name, email);
	  }

}
