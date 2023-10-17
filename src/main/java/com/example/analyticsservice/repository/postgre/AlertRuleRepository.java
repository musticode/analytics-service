package com.example.analyticsservice.repository.postgre;

import com.example.analyticsservice.dto.alert.AlertRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRuleRepository extends JpaRepository<AlertRule, Long> {
}
