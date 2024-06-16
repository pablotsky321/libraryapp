package org.service.microservicebook.Requests_Responses;

import lombok.*;
import org.service.microservicebook.entities.AuthorEntity;
import org.service.microservicebook.entities.BookEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatedAuthorResponse {

    private String message;
    private AuthorEntity author;

}
