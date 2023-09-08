package com.example.subscription.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Date startDate;
  private Date endDate;
  @ManyToOne
  @JoinColumn(name = "plan_id", nullable = false)
  private Plan plan;
  @Column(nullable = false)
  private Integer userId;

  public Subscription() {
  }

}