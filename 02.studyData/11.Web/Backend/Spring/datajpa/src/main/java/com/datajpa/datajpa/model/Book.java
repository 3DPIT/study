package com.datajpa.datajpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "bookAuthor",
            joinColumns = @JoinColumn(name="bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId")
    )
    private List<Author> authors = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book(String name, List<Author> authors, Category category) {
        this.name = name;
        this.authors = authors;
        this.category = category;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void deleteAuthor(Author author){
        authors.remove(author);
    }
}
