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


  public long getBefore() {
    return before;
  }

  public void setBefore(long before) {
    this.before = before;
  }


  public long getAfter() {
    return after;
  }

  public void setAfter(long after) {
    this.after = after;
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
