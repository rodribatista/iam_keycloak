package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {

  private Integer id;
  private String name;
  private String lastName;
  private String email;
  private SubscriptionDTO subscription;

  public User() {
  }

  public User(Integer id, String name, String lastName, String email) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.email = email;
  }

}