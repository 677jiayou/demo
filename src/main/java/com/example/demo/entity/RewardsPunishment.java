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


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(long employeeNumber) {
    this.employeeNumber = employeeNumber;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
