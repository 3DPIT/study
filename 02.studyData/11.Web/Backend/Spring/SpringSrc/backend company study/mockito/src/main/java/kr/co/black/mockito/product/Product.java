package kr.co.black.mockito.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    String id;
    String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
