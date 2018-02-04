package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lea")
public class Lea {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "employee_number")
  private Integer employeeNumber;
  @Column(name = "department_number")
  private Integer departmentNumber;
  @Column(name = "start_time")
  private java.sql.Date startTime;
  @Column(name ="end_time" )
  private java.sql.Date endTime;
  @Column(name = "days")
  private String days;
  @Column(name = "reason")
  private String reason;
  @Column(name = "type")
  private String type;
  @Column(name = "manager")
  private String manager;
  @Column(name = "status")
  private String status;
  @Column(name = "notes")
  private String notes;

  @Transient
  private Employee employee;
  @Transient
  private Department department;

}
