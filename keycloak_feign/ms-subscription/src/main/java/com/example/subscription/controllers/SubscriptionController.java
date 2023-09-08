package com.example.subscription.controllers;

import com.example.subscription.model.dto.SubscriptionDTO;
import com.example.subscription.service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

  private final ISubscriptionService subscriptionService;

  @Value("${server.port}")
  private int serverPort;

  public SubscriptionController(ISubscriptionService subscriptionService) {
    this.subscriptionService = subscriptionService;
  }

  @GetMapping("/find")
  public SubscriptionDTO findSubscriptionByUser(
    @RequestParam Integer userId, HttpServletResponse response) {
    response.addHeader("port", String.valueOf(serverPort));
    return subscriptionService.findSubscriptionByUserId(userId);
  }

}