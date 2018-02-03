package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name ="department_number" )
  private Integer departmentNumber;
  @Column(name ="name" )
  private String name;
  @Column(name ="notes" )
  private String notes;
  @Column(name ="manager" )
  private String manager;
  @Column(name ="telephone" )
  private String telephone;
  @Column(name ="address" )
  private String address;


}
