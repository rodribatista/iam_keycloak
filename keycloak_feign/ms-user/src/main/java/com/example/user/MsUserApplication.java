package com.example.user;

import com.example.user.repository.FeignSubscriptionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(
  clients = FeignSubscriptionRepository.class)
@SpringBootApplication
public class MsUserApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsUserApplication.class, args);
  }

}