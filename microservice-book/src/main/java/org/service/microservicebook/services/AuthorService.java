package org.service.microservicebook.services;

import org.service.microservicebook.DTOs.AuthorDTO;
import org.service.microservicebook.Requests_Responses.CreatedAuthorResponse;
import org.service.microservicebook.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {

    List<AuthorEntity> getAllAuthors();

    AuthorDTO getAuthorById(String id);

    CreatedAuthorResponse createAuthor(AuthorEntity author);

    List<AuthorEntity> createAuthors(List<AuthorEntity> authors);

    String updateAuthor(AuthorEntity author);

    String deleteAuthor(String id);

}
