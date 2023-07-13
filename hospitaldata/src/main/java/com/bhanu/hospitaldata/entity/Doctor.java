package com.bhanu.hospitaldata.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Doctor 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String name;
  
  private String email;
  
  private String specilization;
  
  private Boolean availability;
  
  @ManyToMany(mappedBy = "doctors")
  private List<Person> person;
  
}
