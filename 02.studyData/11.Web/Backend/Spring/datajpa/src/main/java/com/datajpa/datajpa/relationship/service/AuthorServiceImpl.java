package com.datajpa.datajpa.relationship.service;

import com.datajpa.datajpa.relationship.dto.requestDto.AuthorRequestDto;
import com.datajpa.datajpa.relationship.dto.responseDto.AuthorResponseDto;
import com.datajpa.datajpa.relationship.model.Author;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Override
    public AuthorResponseDto addAuthorResponseDto(AuthorRequestDto authorRequestDto) {
        return null;
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        return null;
    }

    @Override
    public AuthorResponseDto getAuthorById(Long authorId) {
        return null;
    }

    @Override
    public Author getAuthor(Long authorId) {
        return null;
    }

    @Override
    public AuthorResponseDto deleteAuthor(Long authorId) {
        return null;
    }

    @Override
    public AuthorResponseDto editZipCode(Long authorId, AuthorRequestDto authorRequestDto) {
        return null;
    }

    @Override
    public AuthorResponseDto addCityToZipcode(Long authorId, Long zipcodeId) {
        return null;
    }

    @Override
    public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId) {
        return null;
    }
}
