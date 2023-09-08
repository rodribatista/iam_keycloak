package com.example.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties
public class SubscriptionDTO {

  private Integer id;
  private Date startDate;
  private Date endDate;
  private String namePlan;
  private String pricePlan;
  private Integer userId;

  public SubscriptionDTO() {
  }

}