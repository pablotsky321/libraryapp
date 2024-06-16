package org.service.microservicebook.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microservicebook.entities.embbededdocs.Commercial_Information;
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
    @NotBlank
    @Field(name = "title")
    private String title;
    @NotBlank
    @Field(name = "subtitle")
    private String subtitle;
    @NotBlank
    @Field(name = "summary")
    private String summary;
    @NotBlank
    @Field(name = "publication_date",targetType = FieldType.DATE_TIME)
    private LocalDate publishedDate;
    @NotBlank
    @Field(name = "authors")
    @DocumentReference(collection = "Authors")
    private List<AuthorEntity> authors;
    @NotBlank
    @Field(name = "commercial_information")
    private Commercial_Information comercialInformation;
    @Field(name = "genres")
    private List<String> genres;


}
