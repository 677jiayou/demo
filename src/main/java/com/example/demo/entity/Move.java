package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "move")
public class Move {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "employee_number")
  private Integer employeeNumber;
  @Column(name = "before")
  private Integer before;
  @Column(name = "after")
  private Integer after;
  @Column(name = "time")
  private java.sql.Timestamp time;
  @Column(name = "manager")
  private String manager;
  @Column(name = "notes")
  private String notes;

  //字段外属性
  @Transient
  private Department department;
  @Transient
  private Department department2;
  @Transient
  private Employee employee;


}
