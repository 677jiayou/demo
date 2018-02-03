package com.example.demo.entity;



import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {
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
  private java.sql.Date birthday;
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
  @Column(name = "department_number")
  private Integer departmentNumber;
  @Column(name = "position_number")
  private Integer positionNumber;
  @Column(name = "in_time")
  private java.sql.Date inTime;
  @Column(name = "password")
  private String password;
  @Column(name = "notes")
  private String notes;

}
