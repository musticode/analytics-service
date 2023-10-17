package com.example.analyticsservice.dto.alert;

import com.example.analyticsservice.model.LogData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "alert_rules")
public class AlertRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String sendingMailAddress;

    @OneToMany(mappedBy = "alertRule", cascade = CascadeType.ALL) // Cascade operations to related applications
    @JsonIgnore
    private List<LogData> logDataList;

}
