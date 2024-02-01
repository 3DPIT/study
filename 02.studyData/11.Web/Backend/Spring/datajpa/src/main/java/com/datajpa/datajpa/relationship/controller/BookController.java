package com.datajpa.datajpa.relationship.controller;

import com.datajpa.datajpa.relationship.dto.requestDto.BookRequestDto;
import com.datajpa.datajpa.relationship.dto.responseDto.BookResponseDto;
import com.datajpa.datajpa.relationship.model.Book;
import com.datajpa.datajpa.relationship.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody final BookRequestDto bookRequestDto){
        BookResponseDto book = bookService.addBook(bookRequestDto);
    }

}
