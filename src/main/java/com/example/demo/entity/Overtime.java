package com.example.demo.entity;


import lombok.Data;

@Data
public class Overtime {

  private long id;
  private long departmentNumber;
  private long employeeNumber;
  private java.sql.Date day;
  private java.sql.Time startTime;
  private java.sql.Time endTime;
  private String notes;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(long departmentNumber) {
    this.departmentNumber = departmentNumber;
  }


  public long getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(long employeeNumber) {
    this.employeeNumber = employeeNumber;
  }


  public java.sql.Date getDay() {
    return day;
  }

  public void setDay(java.sql.Date day) {
    this.day = day;
  }


  public java.sql.Time getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Time startTime) {
    this.startTime = startTime;
  }


  public java.sql.Time getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Time endTime) {
    this.endTime = endTime;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
