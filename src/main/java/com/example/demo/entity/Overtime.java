package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
  private Date day;
  @Column(name = "start_time")
  private Date startTime;
  @Column(name = "end_time")
  private Date endTime;
  @Column(name = "notes")
  private String notes;

  @Transient
  private Employee employee;
  @Transient
  private Department department;
  @Transient
  private String day1;
  @Transient
  private  String start;
  @Transient
  private  String end;


}
