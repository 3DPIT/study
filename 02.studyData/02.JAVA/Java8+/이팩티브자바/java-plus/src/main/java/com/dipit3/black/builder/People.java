package com.dipit3.black.builder;


public class People {
    private String name ;
    private String address;
    private long age;

   public static class Builder{
       //필수 매개변수
       private String name;

       //선택 매개변수
       private String address ="";
       private long age =0;

       public Builder(String name){
           this.name = name;
       }

       public Builder address(String val){
           address = val;
           return this;
       }
       public Builder age(long val){
           age = val;
           return this;
       }

       public People build(){
           return new People(this);
       }
   }

   private People(Builder builder){
       name = builder.name;
       address = builder.address;
       age = builder.age;
   }
}




