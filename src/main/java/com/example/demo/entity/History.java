package com.example.demo.entity;


import lombok.Data;

@Data
public class History {

  private long id;
  private long employeeNumber;
  private String name;
  private String gender;
  private java.sql.Date birthday;
  private String telephone;
  private String email;
  private String address;
  private String photo;
  private String education;
  private java.sql.Date inTime;
  private java.sql.Date outTime;
  private long departmentNumber;
  private long positionNumber;
  private String status;
  private String home;
  private String notes;


}
