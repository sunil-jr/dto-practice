package com.spring.demo123.service;

import com.spring.demo123.dto.BookRequest;
import com.spring.demo123.dto.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse addBook(BookRequest bookRequest);

    BookResponse editBook(Long id, BookRequest bookRequest);

    List<BookResponse> getAllBooks();

    BookResponse getBookById(Long id);

    void deleteById(Long id);

}
