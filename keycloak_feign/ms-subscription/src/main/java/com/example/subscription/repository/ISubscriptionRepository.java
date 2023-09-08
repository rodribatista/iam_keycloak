package com.example.subscription.repository;

import com.example.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubscriptionRepository extends JpaRepository<Subscription, Integer> {

  Subscription findByUserId(Integer userId);

}