package org.service.microservicebook.DTOs;

import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {

    private String id;
    private String name;
    private String lastname;
    private String nickname;
    private LocalDateTime birth_date;
    private LocalDateTime death_date;
    private String death_place;
    private String short_biography;

}
