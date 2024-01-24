package com.tui.proof.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class OrderPilote {
  @Id
  @GeneratedValue
  private long number;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Address deliveryAddress;
  private int pilotes;
  private float orderTotal;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Client client;
  private StatusOrder statusOrder;
  private LocalDateTime creationDateTime;

  public OrderPilote(long number, Address deliveryAddress, int pilotes, float orderTotal, Client client, StatusOrder statusOrder) {
    this.number = number;
    this.deliveryAddress = deliveryAddress;
    this.pilotes = pilotes;
    this.orderTotal = orderTotal;
    this.client = client;
    this.statusOrder = statusOrder;
  }

  public OrderPilote() {
  }
}
