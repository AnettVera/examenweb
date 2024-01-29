package mx.edu.utez.examenu1.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examenu1.models.book.Book;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class BookDto {
    private Long id;
    @NotEmpty
    private String title;

    private String isbn;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastname;
    private Long paginas;
    @NotEmpty
    private String categoria;

    private LocalDate datepublic;
    private String folio;

    public Book toEntity(){
        return new Book(title, isbn, name, lastname, paginas, categoria,datepublic);
    }

}
