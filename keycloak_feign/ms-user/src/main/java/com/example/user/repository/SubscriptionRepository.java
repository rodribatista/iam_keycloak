package com.example.user.repository;

import com.example.user.model.SubscriptionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionRepository {

  private final FeignSubscriptionRepository feignSubscriptionRepository;

  public SubscriptionRepository(FeignSubscriptionRepository feignSubscriptionRepository) {
    this.feignSubscriptionRepository = feignSubscriptionRepository;
  }

  public SubscriptionDTO findByUserId(Integer userId) {
    System.out.println("solicitando informacion a suscription service mediante feign");
    ResponseEntity<SubscriptionDTO> response = feignSubscriptionRepository.findByUserId(userId);
    return response.getBody();
  }

}