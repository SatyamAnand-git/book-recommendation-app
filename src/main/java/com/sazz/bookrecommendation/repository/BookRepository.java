package com.sazz.bookrecommendation.repository;

import com.sazz.bookrecommendation.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface BookRepository
        extends MongoRepository<Book, String> {

    List<Book> findByGenre(String genre);
    List<Book> findByAuthor(String author);

}