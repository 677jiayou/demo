package com.example.demo.entity;


import lombok.Data;

@Data
public class Position {

  private long id;
  private long positionNumber;
  private String name;
  private String level;
  private String notes;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPositionNumber() {
    return positionNumber;
  }

  public void setPositionNumber(long positionNumber) {
    this.positionNumber = positionNumber;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
