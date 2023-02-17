package com.distribuida.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "BookDto", description = "Contiene informacion de un Libro")
public class BookDto {
    private Integer id;
    private String isbn;
    private String title;
    private String author;
    private Double price;

    private String authorName;
}
