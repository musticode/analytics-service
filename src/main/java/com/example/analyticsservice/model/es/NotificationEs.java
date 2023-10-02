package com.example.analyticsservice.model.es;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "notifications")
public class NotificationEs {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "timestamp")
    private Date timestamp;

    @Field(type = FieldType.Text, name = "source")
    private String source;

    @Field(type = FieldType.Text, name = "message")
    private String message;

    @Field(type = FieldType.Text, name = "severity")
    private String severity;
}
