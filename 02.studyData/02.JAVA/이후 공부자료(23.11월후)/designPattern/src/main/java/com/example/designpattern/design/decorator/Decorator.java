package com.example.designpattern.design.decorator;

public abstract class Decorator extends Item{

    Item item;

    public Decorator(Item item) {
        this.item = item;
    }
}
