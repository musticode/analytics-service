package com.example.analyticsservice.model.mongo;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.index.Indexed;


import java.util.Date;
@Document(collection = "logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Log {

    @Id
    @Indexed(unique=true)
    private String  id;
    private Date timestamp;
    private String source;
    private String message;
    private String severity;

}
