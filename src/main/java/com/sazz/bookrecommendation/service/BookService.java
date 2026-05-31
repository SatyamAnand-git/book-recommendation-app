package com.sazz.bookrecommendation.service;

import com.sazz.bookrecommendation.model.Book;
import com.sazz.bookrecommendation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book){

        bookRepository.save(book);

    }
    public List<Book> getAllBooks(){

        return bookRepository.findAll();

    }
    public void updateBook(String id, Book updatedBook){

        updatedBook.setId(id);

        bookRepository.save(updatedBook);

    }
    public void deleteBook(String id){

        bookRepository.deleteById(id);

    }
    public List<Book> getBooksByGenre(String genre){

        return bookRepository.findByGenre(genre);

    }
    public List<Book> getBooksByAuthor(String author){

        return bookRepository.findByAuthor(author);

    }
    public Book getBookById(String id){

        return bookRepository.findById(id).orElse(null);

    }
}
