package com.bhanu.hospitaldata.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class MedicalHistory 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name="patient_name")
  private String patient;
  
  @OneToOne
  @JoinColumn
  @Column(nullable = false)
  private Person person;
  
  @OneToMany
  private List<MedicalObservation> observations;
  
  
  
  
}
