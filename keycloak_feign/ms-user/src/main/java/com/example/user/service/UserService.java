package com.example.user.service;

import com.example.user.model.SubscriptionDTO;
import com.example.user.model.User;
import com.example.user.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class UserService {

  private final List<User> userRepository;
  private final SubscriptionRepository subscriptionRepository;

  public UserService(SubscriptionRepository subscriptionRepository) {
    this.userRepository = List.of(
      new User(1, "Steve", "Jobs", "steve.jobs@apple.com"),
      new User(2, "Jeff", "Bezos", "jeff.bezos@amazon.com"),
      new User(3, "Elon", "Musk", "elon.musk@tesla.com")
    );
    this.subscriptionRepository = subscriptionRepository;
  }

  public User findById(Integer id) {
    User user = userRepository.stream()
      .filter(_user -> Objects.equals(_user.getId(), id))
      .findFirst().orElse(null);
    SubscriptionDTO subscriptionDTO = subscriptionRepository.findByUserId(id);
    if (user != null)
      user.setSubscription(subscriptionDTO);
    return user;
  }

}