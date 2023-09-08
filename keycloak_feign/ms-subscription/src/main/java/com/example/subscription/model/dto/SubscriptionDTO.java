package com.example.subscription.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class SubscriptionDTO {

  private Integer id;
  private Date startDate;
  private Date endDate;
  private String namePlan;
  private String pricePlan;
  private Integer userId;

}