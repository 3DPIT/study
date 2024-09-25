package com.dipit3.black;

import com.dipit3.black.builder.People;

import static com.dipit3.black.builder.People.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        People people = new Builder("경민")
                .address("서울")
                .build();
    }
}