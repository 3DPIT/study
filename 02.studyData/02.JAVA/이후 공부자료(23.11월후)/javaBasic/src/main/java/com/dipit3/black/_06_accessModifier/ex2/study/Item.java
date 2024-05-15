package com.dipit3.black._06_accessModifier.ex2.study;

public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getTotalPrice(){
        return this.price* this.quantity;
    }
}

//public class Item {
//    private String name;
//    private int price;
//    private int quantity;
//
//    public Item(String name, int price, int quantity){
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//}
