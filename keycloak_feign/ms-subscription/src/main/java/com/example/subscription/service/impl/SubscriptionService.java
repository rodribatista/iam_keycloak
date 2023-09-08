package com.example.subscription.service.impl;

import com.example.subscription.model.Plan;
import com.example.subscription.model.Subscription;
import com.example.subscription.model.dto.SubscriptionDTO;
import com.example.subscription.repository.IPlanRepository;
import com.example.subscription.repository.ISubscriptionRepository;
import com.example.subscription.service.ISubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService implements ISubscriptionService {

  private final IPlanRepository planRepository;
  private final ISubscriptionRepository subscriptionRepository;

  public SubscriptionService(IPlanRepository planRepository, ISubscriptionRepository subscriptionRepository) {
    this.planRepository = planRepository;
    this.subscriptionRepository = subscriptionRepository;
  }

  @Override
  public SubscriptionDTO findSubscriptionByUserId(Integer userId) {
    Subscription subscription = subscriptionRepository.findByUserId(userId);
    Plan plan = planRepository.findById(subscription.getPlan().getId())
      .orElse(null);
    return SubscriptionDTO.builder()
      .id(subscription.getId())
      .startDate(subscription.getStartDate())
      .endDate(subscription.getEndDate())
      .namePlan(plan.getName())
      .pricePlan(plan.getPrice())
      .userId(subscription.getUserId())
      .build();
  }

}