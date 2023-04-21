package com.spring.demo123.controller;

import com.spring.demo123.dto.BookRequest;
import com.spring.demo123.dto.BookResponse;
import com.spring.demo123.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookResponse addBook(@RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }

    @PutMapping("/{id}/edit")
    public BookResponse editBook(@PathVariable(value = "id") Long id, @RequestBody BookRequest bookRequest) {
        return bookService.editBook(id, bookRequest);
    }

    @GetMapping("/all")
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }


}
