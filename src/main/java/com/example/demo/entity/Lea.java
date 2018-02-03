package com.example.demo.entity;


import lombok.Data;

@Data
public class Lea {

  private long id;
  private long employeeNumber;
  private long departmentNumber;
  private java.sql.Date startTime;
  private java.sql.Date endTime;
  private String days;
  private String reason;
  private String type;
  private String manager;
  private String status;
  private String notes;



}
