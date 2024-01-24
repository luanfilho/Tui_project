package com.tui.proof.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import jakarta.persistence.Entity;

@Data
@Entity
public class Client {
  @Id
  @GeneratedValue
  private long id;
  private String firstName;
  private String lastName;
  @Pattern(regexp="[\\d]{9}", message="This field should contain 9 digits!")
  private String telephone;

  public Client(long id, String firstName, String lastName, String telephone) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
  }

  public Client() {
  }
}
