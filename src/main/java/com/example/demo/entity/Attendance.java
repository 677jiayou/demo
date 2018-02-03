package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "employee_number")
  private Integer employeeNumber;
  @Column(name = "day")
  private java.sql.Date day;
  @Column(name = "time_type")
  private String timeType;
  @Column(name = "start_time")
  private java.sql.Time startTime;
  @Column(name = "start_type")
  private String startType;
  @Column(name = "end_time")
  private java.sql.Time endTime;
  @Column(name = "end_type")
  private String endType;
  @Column(name = "work_type")
  private String workType;
  @Column(name = "notes")
  private String notes;
  //字段外属性
  @Transient
  private Employee employee;

}
