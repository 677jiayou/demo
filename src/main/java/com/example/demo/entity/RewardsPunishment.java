package com.example.demo.entity;


import lombok.Data;

@Data
public class RewardsPunishment {

  private long id;
  private long employeeNumber;
  private String type;
  private String reason;
  private double money;
  private java.sql.Timestamp time;
  private String manager;
  private String notes;



}
