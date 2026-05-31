package com.sazz.bookrecommendation.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sazz.bookrecommendation.model.Book;
import com.sazz.bookrecommendation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<String> addBook(
            @Valid @RequestBody Book book){

        bookService.saveBook(book);

        return new ResponseEntity<>(
                "Book Saved Successfully",
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){

        return ResponseEntity.ok(
                bookService.getAllBooks()
        );

    }
    @PutMapping("/{id}")
    public String updateBook(
            @PathVariable String id,
            @Valid @RequestBody Book  updatedBook){

        bookService.updateBook(id, updatedBook);

        return "Book Updated Successfully";


    }
    @DeleteMapping("/{id}")
    public String deleteBook(
            @PathVariable String id){

        bookService.deleteBook(id);

        return "Book Deleted Successfully";

    }
    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(
            @PathVariable String genre){

        return bookService.getBooksByGenre(genre);

    }
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(
            @PathVariable String author){

        return bookService.getBooksByAuthor(author);

    }
    @GetMapping("/{id}")
    public Book getBookById(
            @PathVariable String id){

        return bookService.getBookById(id);

    }
}