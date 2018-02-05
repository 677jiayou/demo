package com.example.demo.entity;


import lombok.Data;

@Data
public class RewardsPunishment {

  private Integer id;
  private Integer employeeNumber;
  private String type;
  private String reason;
  private double money;
  private java.sql.Timestamp time;
  private String manager;
  private String notes;



}
