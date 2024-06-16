package org.service.microservicebook.DTOs;

import lombok.*;
import org.service.microservicebook.entities.embbededdocs.Commercial_Information;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private String id;
    private String title;
    private String subtitle;
    private String summary;

}
