package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/find/{id}")
  public User findById(@PathVariable Integer id) {
    return userService.findById(id);
  }

}