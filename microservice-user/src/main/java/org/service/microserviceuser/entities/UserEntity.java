package org.service.microserviceuser.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class UserEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    @NotBlank
    @Field(name = "name")
    private String name;
    @NotBlank
    @Field(name = "lastname")
    private String lastname;
    @NotBlank
    @Field(name = "email")
    private String email;
    @NotBlank
    @Field(name = "docId")
    @Indexed(unique = true)
    private String doc;
    @NotBlank
    @Field(name = "phone")
    private String phone;

}
