package com.datajpa.datajpa.relationship.service;

import com.datajpa.datajpa.relationship.dto.requestDto.AuthorRequestDto;
import com.datajpa.datajpa.relationship.dto.requestDto.ZipcodeRequestDto;
import com.datajpa.datajpa.relationship.dto.responseDto.AuthorResponseDto;
import com.datajpa.datajpa.relationship.model.Author;
import com.datajpa.datajpa.relationship.model.Zipcode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public AuthorResponseDto addAuthorResponseDto(AuthorRequestDto authorRequestDto);
    public List<AuthorResponseDto> getAuthors();
    public AuthorResponseDto getAuthorById(Long authorId);
    public Author getAuthor (Long authorId);
    public AuthorResponseDto deleteAuthor(Long authorId);
    public AuthorResponseDto editZipCode(Long authorId, AuthorRequestDto authorRequestDto);
    public AuthorResponseDto addCityToZipcode(Long authorId, Long zipcodeId);
    public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId);
}
