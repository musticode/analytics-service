package com.example.analyticsservice.model;

import com.example.analyticsservice.model.mongo.Log;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "organizations")
public class Organization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int appCount;



    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL) // Cascade operations to related applications
    @JsonIgnore
    private List<Application> applications;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL) // Cascade operations to related applications
    @JsonIgnore
    private List<LogData> logs;


}
