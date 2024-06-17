package org.service.microservicebooking.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BookDTO {
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "title")
    private String title;
    @Field(name = "subtitle")
    private String subtitle;
    @Field(name = "summary")
    private String summary;
}
