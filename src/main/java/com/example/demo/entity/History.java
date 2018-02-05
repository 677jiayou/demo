package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "history")
public class History {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "employee_number")
  private Integer employeeNumber;
  @Column(name = "name")
  private String name;
  @Column(name = "gender")
  private String gender;
  @Column(name = "birthday")
  private Date birthday;
  @Column(name = "telephone")
  private String telephone;
  @Column(name = "email")
  private String email;
  @Column(name = "address")
  private String address;
  @Column(name = "photo")
  private String photo;
  @Column(name = "education")
  private String education;
  @Column(name = "in_time")
  private Date inTime;
  @Column(name = "out_time")
  private Date outTime;
  @Column(name = "department_number")
  private Integer departmentNumber;
  @Column(name = "position_number")
  private Integer positionNumber;
  @Column(name = "status")
  private String status;
  @Column(name = "home")
  private String home;
  @Column(name = "notes")
  private String notes;

  //字段外属性
  @Transient
  private Department department;
  @Transient
  private Position position;

}
