package com.dipit3.black.basic._09_inheritance.ex1.study;

public class Book extends Item{
    private String author;
    private int isbn;

    public Book(String name, int price, String author, int isbn){
        super(name, price);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 저자:"+author+", isbn:"+isbn);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
