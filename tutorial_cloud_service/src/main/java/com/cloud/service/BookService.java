package com.cloud.service;

import com.cloud.domain.Book;
import com.cloud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Jimmy. 2018/6/3  21:10
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void saveOrUpDate(Book book){
        bookRepository.save(book);
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }
}
