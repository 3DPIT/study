package com.example.jpadata1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name ="Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book>books = new ArrayList<>();

    public Category(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public void addBooks(Book book){
        books.add(book);
    }

    public void removeBooks(Book book){
        books.remove(book);
    }
}
