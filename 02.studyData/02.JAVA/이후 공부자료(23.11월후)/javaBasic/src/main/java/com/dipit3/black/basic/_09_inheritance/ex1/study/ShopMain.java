package com.dipit3.black.basic._09_inheritance.ex1.study;

public class ShopMain {
    public static void main(String[] args) {
        Book book = new Book("JAVA", 10000, " han", 12345);
        Album album = new Album("앨범1", 15000, "seo");
        Movie movie = new Movie("영화1",18000,"감독1","배우1");

        book.print();
        album.print();
        movie.print();

        int sum = book.getPrice()+ album.getPrice() + movie.getPrice();
        System.out.println("상품 가격의 합:"+ sum);
    }
}
        /*
        이름:JAVA, 가격:10000
        - 저자:han, isbn:12345
        이름:앨범1, 가격:15000
        - 아티스트:seo
        이륾:영화1, 가격:18000
        - 감독:감독1, 배우: 배우1
        상품 가격의 합: 43000
         */
//TODO 위의 출력 형식에 맞게 class 만들기
/**
 * 코드 중복 없이 상속 관계 사용
 * 부모 클래스 Item이라는 이름 사용
 * 공통 속성: name, price
 * Book: 저자(author), isbn(isbn)
 * Album: 아티스트(artist)
 * Movie: 감독(dirctor), 배우(actor)
 */