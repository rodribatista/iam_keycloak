package com.example.user.repository;

import com.example.user.config.feignGetNewToken.OAuthFeignConfig;
import com.example.user.config.feignForwardToken.FeignInterceptor;
import com.example.user.model.SubscriptionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
  name = "subscription-service",
  url = "http://localhost:8085",
  // REENVIO DE TOKEN GATEWAY
  configuration = FeignInterceptor.class)
  // SOLICITUD TOKEN NUEVO
  //configuration = OAuthFeignConfig.class)
public interface FeignSubscriptionRepository {

  @RequestMapping(method = RequestMethod.GET, value = "/subscription/find")
  ResponseEntity<SubscriptionDTO> findByUserId(@RequestParam Integer userId);

}