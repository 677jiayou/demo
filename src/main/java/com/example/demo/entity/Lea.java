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


  public long getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(long departmentNumber) {
    this.departmentNumber = departmentNumber;
  }


  public java.sql.Date getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Date startTime) {
    this.startTime = startTime;
  }


  public java.sql.Date getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Date endTime) {
    this.endTime = endTime;
  }


  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
