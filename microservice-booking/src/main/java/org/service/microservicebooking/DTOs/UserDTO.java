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
public class UserDTO {

    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "lastname")
    private String lastname;
    @Field(name = "email")
    private String email;
    @Field(name = "docId")
    private String doc;
    @Field(name = "phone")
    private String phone;

}
