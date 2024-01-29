package mx.edu.utez.examenu1.models.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80, nullable = false)
    private String lastname;

    @Column(nullable = false)
    private Long paginas;

    @Column(length = 80, nullable = false)
    private String categoria;

    @Column(columnDefinition ="DATE", nullable = false)
    private LocalDate datepublic;

    @Column
    private String folio;


    public Book(String title, String isbn, String name, String lastname, Long paginas, String categoria, LocalDate datepublic) {
        this.title = title;
        this.isbn = isbn;
        this.name = name;
        this.lastname = lastname;
        this.paginas = paginas;
        this.categoria = categoria;
        this.datepublic = datepublic;
    }

    public Book(String title, String isbn, String name, String lastname, Long paginas, String categoria, LocalDate datepublic, String folio) {
        this.title = title;
        this.isbn = isbn;
        this.name = name;
        this.lastname = lastname;
        this.paginas = paginas;
        this.categoria = categoria;
        this.datepublic = datepublic;
        this.folio = folio;
    }


}
