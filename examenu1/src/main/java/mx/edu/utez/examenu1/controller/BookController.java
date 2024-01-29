package mx.edu.utez.examenu1.controller;

import jakarta.validation.Valid;
import mx.edu.utez.examenu1.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllBooks(){
        return bookService.getAll();
    }



    @PostMapping("/")
    public ResponseEntity<?> creatBook(@Valid @RequestBody BookDto bookDto){
        return bookService.save(
                bookDto.toEntity()
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }

    @GetMapping({"/{title}"})
    public ResponseEntity<?>getBook(@PathVariable String title){
        return  bookService.getName(title);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>actualizarBook(@RequestBody BookDto bookDto){
        return bookService.save(
                bookDto.toEntity()
        );
    }
}
