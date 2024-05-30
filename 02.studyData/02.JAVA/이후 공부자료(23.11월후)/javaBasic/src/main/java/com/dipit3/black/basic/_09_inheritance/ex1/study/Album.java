package com.dipit3.black.basic._09_inheritance.ex1.study;

public class Album extends Item{
    private String artist;

    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 아티스트:"+artist);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
