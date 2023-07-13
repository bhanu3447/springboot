package com.bhanu.CustomerDataManagement.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bhanu.CustomerDataManagement.dto.CustomerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_info")
public class Customer implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(nullable = false)
  private String name;
  
  private String email;
  
  
  public Customer(CustomerDto customerDto)
  {
	  this.id=customerDto.getId();
	  
	  this.name=customerDto.getName();
	  
	  this.email=customerDto.getEmail();
  }
  
}

