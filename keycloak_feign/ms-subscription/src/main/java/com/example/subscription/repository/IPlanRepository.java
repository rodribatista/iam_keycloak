package com.example.subscription.repository;

import com.example.subscription.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlanRepository extends JpaRepository<Plan,Integer> {
}