package com.bhanu.hospitaldata.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "medical_observation")
public class MedicalObservation
{
  private Integer id;
  
  private String encounter;
  
  @OneToMany
  private List<Doctor> doctors;
  
  @ManyToOne
  @Column(nullable = false)
  private MedicalHistory history;
}
