package com.datajpa.datajpa.relationship.service;

import com.datajpa.datajpa.relationship.dto.Mapper;
import com.datajpa.datajpa.relationship.dto.requestDto.BookRequestDto;
import com.datajpa.datajpa.relationship.dto.responseDto.BookResponseDto;
import com.datajpa.datajpa.relationship.model.Author;
import com.datajpa.datajpa.relationship.model.Book;
import com.datajpa.datajpa.relationship.model.Category;
import com.datajpa.datajpa.relationship.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Transactional
    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setName(bookRequestDto.getName());
        if(bookRequestDto.getAuthorIds().isEmpty()){
            throw new IllegalArgumentException("you need at least on author");
        }else{
            List<Author> authors = new ArrayList<>();
            for(Long authorId : bookRequestDto.getAuthorIds()){
                Author author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            book.setAuthors(authors);
        }
        if(bookRequestDto.getCategroyId() == null){
            throw new IllegalArgumentException("book at least on category");
        }
        Category category = categoryService.getCategory(bookRequestDto.getCategroyId());
        book.setCategory(category);

        Book book1 = bookRepository.save(book);
        return Mapper.bookToBookResponseDto(book1);
    }

    @Override
    public BookResponseDto getBookById(Long bookId) {
        Book book = getBook(bookId);
        return Mapper.bookToBookResponseDto(book);
    }

    @Override
    public Book getBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new IllegalArgumentException("cannot find book with id: "+ bookId));
        return book;
    }

    @Override
    public List<BookResponseDto> getBooks() {
        List<Book> books = StreamSupport
                .stream(bookRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return Mapper.booksToBookResponseDtos(books);
    }

    @Override
    public BookResponseDto deleteBook(Long bookId) {
        Book book = getBook(bookId);
        bookRepository.delete(book);
        return Mapper.bookToBookResponseDto(book);
    }

    @Override
    public BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto) {
        return null;
    }

    @Override
    public BookResponseDto addAuthorToBook(Long bookId, Long authorId) {
        return null;
    }

    @Override
    public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId) {
        return null;
    }

    @Override
    public BookResponseDto addCategoryToBook(Long bookId, Long categoryId) {
        return null;
    }

    @Override
    public BookResponseDto removeCategoryFromBook(Long bookId, Long categoryId) {
        return null;
    }
}
