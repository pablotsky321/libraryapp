package org.service.microservicebook.services;

import org.service.microservicebook.DTOs.AuthorDTO;
import org.service.microservicebook.Requests_Responses.CreatedAuthorResponse;
import org.service.microservicebook.entities.AuthorEntity;
import org.service.microservicebook.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<AuthorEntity> getAllAuthors() {
        if(authorRepository.findAll().isEmpty()) {
            return new ArrayList<AuthorEntity>();
        }else{
            return authorRepository.findAll();
        }
    }

    @Override
    public AuthorDTO getAuthorById(String id) {
        Optional<AuthorEntity> findAuthor = authorRepository.findById(id);
        if(findAuthor.isEmpty()){
            return new AuthorDTO();
        }else{
            return AuthorDTO
                    .builder()
                    .id(findAuthor.get().getId())
                    .name(findAuthor.get().getName())
                    .lastname(findAuthor.get().getLastname())
                    .nickname(findAuthor.get().getNickname())
                    .birth_date(findAuthor.get().getBirth_date())
                    .death_date(findAuthor.get().getDeath_date())
                    .death_place(findAuthor.get().getDeath_place())
                    .short_biography(findAuthor.get().getShort_biography())
                    .build();
        }
    }

    @Override
    public CreatedAuthorResponse createAuthor(AuthorEntity author) {
        return new CreatedAuthorResponse("author created",authorRepository.save(author));
    }

    @Override
    public List<AuthorEntity> createAuthors(List<AuthorEntity> authors) {
        return authorRepository.saveAll(authors);
    }

    @Override
    public String updateAuthor(AuthorEntity author) {
        if(authorRepository.findById(author.getId()).isEmpty()){
            return "Author not found";
        }else{
            authorRepository.save(author);
            return "Author updated";
        }
    }

    @Override
    public String deleteAuthor(String id) {
        if(authorRepository.findById(id).isEmpty()){
            return "Author not found";
        }else{
            authorRepository.deleteById(id);
            return "Author deleted";
        }
    }
}
