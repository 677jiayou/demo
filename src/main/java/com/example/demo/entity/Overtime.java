package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "overtime")
public class Overtime {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "department_number")
  private Integer departmentNumber;
  @Column(name = "employee_number")
  private Integer employeeNumber;
  @Column(name = "day")
  private java.sql.Date day;
  @Column(name = "start_time")
  private java.sql.Time startTime;
  @Column(name = "end_time")
  private java.sql.Time endTime;
  @Column(name = "notes")
  private String notes;

  @Transient
  private Employee employee;
  @Transient
  private Department department;


}
