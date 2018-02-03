package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "position")
public class Position {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name ="position_number" )
  private Integer positionNumber;
  @Column(name ="name" )
  private String name;
  @Column(name ="level" )
  private String level;
  @Column(name ="notes" )
  private String notes;

}
