package com.datajpa.datajpa.dto;

import com.datajpa.datajpa.dto.responseDto.AuthorResponseDto;
import com.datajpa.datajpa.dto.responseDto.BookResponseDto;
import com.datajpa.datajpa.model.Author;
import com.datajpa.datajpa.model.Book;

import java.util.ArrayList;
import java.util.List;


public class Mapper {
    public static BookResponseDto bookToBookResponseDto(Book book){
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setCategoryName(book.getCategory().getName());
        List<String> names = new ArrayList<>();
        List<Author> authors = book.getAuthors();
        for(Author autor: authors){
            names.add(autor.getName());
        }
        bookResponseDto.setAuthorNames(names);
        return bookResponseDto;
    }

    public static List<BookResponseDto> booksToBookResponseDtos(List<Book> books){
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for(Book book: books){
            bookResponseDtos.add(bookToBookResponseDto(book));
        }
        return bookResponseDtos;
    }

    public static AuthorResponseDto authorToAuthorResponseDto(Author author){
                AuthorResponseDto authorResponseDto = new AuthorResponseDto();
                authorResponseDto.setId(author.getId());
                authorResponseDto.setName(author.getName());
                List<String> names = new ArrayList<>();
                List<Book> books = author.getBooks();
                for(Book book: books){
                    names.add(book.getName());
                }
                authorResponseDto.setBookNames(names);
                return authorResponseDto;
    }

    public static List<AuthorResponseDto> authorsToAuthorResponseDtos(List<Author> authors){
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for(Author author: authors){
            authorResponseDtos.add(authorToAuthorResponseDto(author));
        }
        return authorResponseDtos;
    }
    //TODO: remain mapper 작성
}
