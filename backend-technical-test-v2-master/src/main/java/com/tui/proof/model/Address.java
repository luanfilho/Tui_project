package com.tui.proof.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.Entity;

@Data
@Entity
public class Address {
  @Id
  @GeneratedValue
  private long id;
  private String street;
  private String postcode;
  private String city;
  private String country;

  public Address(long id, String street, String postcode, String city, String country) {
    this.id = id;
    this.street = street;
    this.postcode = postcode;
    this.city = city;
    this.country = country;
  }

  public Address() {
  }
}
