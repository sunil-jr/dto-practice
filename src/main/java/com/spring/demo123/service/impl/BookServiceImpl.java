package com.spring.demo123.service.impl;

import com.spring.demo123.dto.BookRequest;
import com.spring.demo123.dto.BookResponse;
import com.spring.demo123.entity.Book;
import com.spring.demo123.repository.BookRepository;
import com.spring.demo123.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookResponse addBook(BookRequest bookRequest) {
        return toResponse(repository.save(toEntity(bookRequest)));
    }

    @Override
    public BookResponse editBook(Long id, BookRequest bookRequest) {
        Book existing = repository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
        return toResponse(repository.save(toUpdateEntity(existing, bookRequest)));
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book existing = repository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
        return toResponse(existing);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    private Book toEntity(BookRequest bookRequest){
        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        book.setPrice(bookRequest.getPrice());
        return book;
    }

    private Book toUpdateEntity(Book book, BookRequest bookRequest){
        if(bookRequest.getName()!=null){
            book.setName(bookRequest.getName());
        }
        if(bookRequest.getAuthor()!=null){
            book.setAuthor(bookRequest.getAuthor());
        }
        if(bookRequest.getPrice()!=null){
            book.setPrice(bookRequest.getPrice());
        }
        return book;
    }

    private BookResponse toResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .price(book.getPrice())
                .build();
    }
}
