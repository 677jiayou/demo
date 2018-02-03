package com.example.demo.entity;


import lombok.Data;

@Data
public class Move {

  private long id;
  private long employeeNumber;
  private long before;
  private long after;
  private java.sql.Timestamp time;
  private String manager;
  private String notes;


}
