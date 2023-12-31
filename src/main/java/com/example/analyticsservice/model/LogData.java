package com.example.analyticsservice.model;


import com.example.analyticsservice.dto.alert.AlertRule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "log_data")
public class LogData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date timestamp;
    private String source;
    private String message;
    private String severity;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "alert_rule_id", referencedColumnName = "id")
    private AlertRule alertRule;

}
