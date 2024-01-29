package mx.edu.utez.examenu1.services;

import mx.edu.utez.examenu1.config.ApiResponse;
import mx.edu.utez.examenu1.models.book.Book;
import mx.edu.utez.examenu1.models.book.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository repository;


    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return  new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK),HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ApiResponse>save(Book book){
        int n = (int)(Math.random()*26+1);
        String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z" };
        String aleatorio= abecedario[n]+n;
        String folio= (book.getTitle().substring(0,1)+book.getName().substring(0,1)+book.getLastname().substring(0,2)+book.getDatepublic()+book.getIsbn().substring(0,4)+aleatorio).toUpperCase();
        book.setFolio(folio);
        book = repository.saveAndFlush(book);
        return new ResponseEntity<>(new ApiResponse(book, HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> actualizar(Long id) {
        Optional<Book> foundBook = repository.findById(id);
        if (foundBook.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "BookNotFound"), HttpStatus.NOT_FOUND);
        }

        Book book = foundBook.get();


        int n = (int)(Math.random()*26+1);
        String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z" };
                String aleatorio= abecedario[n]+n;
        String folio= (book.getTitle().substring(0,1)+book.getName().substring(0,1)+book.getLastname().substring(0,2)+book.getDatepublic().toString().replace("-","")+book.getIsbn().substring(0,4)+aleatorio).toUpperCase();
        book.setFolio(folio);
        book = repository.saveAndFlush(book);
        return new ResponseEntity<>(new ApiResponse(book, HttpStatus.OK), HttpStatus.OK);

    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> delete(Long id) {
        Optional<Book> foundBook = repository.findById(id);
        if (foundBook.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "BookNotFound"), HttpStatus.NOT_FOUND);
        }

        Book bookDelete = foundBook.get();


        repository.delete(bookDelete);

        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "BoookDeletedSuccessfully"), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>getName(String title){

            return new ResponseEntity<>(new ApiResponse(repository.findByTitle(title), HttpStatus.OK),HttpStatus.OK);

    }
}
