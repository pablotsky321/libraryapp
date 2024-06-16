package org.service.microservicebook.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class BookEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "title")
    private String title;
    @Field(name = "summary")
    private String summary;
    @Field(name = "publication_date",targetType = FieldType.DATE_TIME)
    private LocalDate publishedDate;
    @Field(name = "authors",targetType = FieldType.ARRAY)
    @DocumentReference(collection = "Authors")
    private List<AutorEntity> authors;


}
