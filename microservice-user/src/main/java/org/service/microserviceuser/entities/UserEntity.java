package org.service.microserviceuser.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
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
    private String name;
    private String lastname;
    private String email;
    private String doc;

}
