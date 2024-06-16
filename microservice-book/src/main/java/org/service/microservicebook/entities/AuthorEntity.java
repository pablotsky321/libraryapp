package org.service.microservicebook.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Authors")
public class AuthorEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "lastname")
    private String lastname;
    @Field(name = "nickname")
    private String nickname;
    @Field(name = "date_of_birth",targetType = FieldType.DATE_TIME)
    private LocalDateTime birth_date;
    @Field(name = "date_of_death",targetType = FieldType.DATE_TIME)
    private LocalDateTime death_date;
    @Field(name = "place_of_death")
    private String death_place;
    @Field(name = "short_biography")
    private String short_biography;

}
