package org.service.microservicebook.entities.embbededdocs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Commercial_Information {

    @NotBlank
    @Field(name = "isbn")
    private String isbn;
    @NotBlank
    @Field(name = "price")
    private double price;
    @NotBlank
    @Field(name = "currency")
    private String currency;
    @NotBlank
    @Field(name = "stock")
    private int stock;

}
