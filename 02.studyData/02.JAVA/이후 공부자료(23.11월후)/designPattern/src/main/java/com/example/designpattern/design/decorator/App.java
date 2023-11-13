package com.example.designpattern.design.decorator;

import java.io.LineNumberReader;

public class App {
    public static void main(String[] args) {
        Strings strings = new Strings();

        strings.add("Hello");
        strings.add("Hello1");
        strings.add("Hello2");
        strings.add("Hello3");
        strings.add("Hello4");
        strings.add("Hello5");

        Item decorator = new SideDecorator(strings, '\"');
        decorator = new BoxDecorator(decorator);

        decorator.print();
    }
}
