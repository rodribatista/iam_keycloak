package com.example.subscription.service;

import com.example.subscription.model.dto.SubscriptionDTO;

public interface ISubscriptionService {

  SubscriptionDTO findSubscriptionByUserId(Integer userId);

}