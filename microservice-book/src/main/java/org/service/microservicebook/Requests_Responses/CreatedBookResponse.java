package org.service.microservicebook.Requests_Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microservicebook.entities.BookEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBookResponse {

    private String message;
    private BookEntity book;

}
