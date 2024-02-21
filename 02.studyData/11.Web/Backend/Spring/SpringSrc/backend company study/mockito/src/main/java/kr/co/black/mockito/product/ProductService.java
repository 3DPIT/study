package kr.co.black.mockito.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProduct(){
        return new Product("KM001", "MacBook");
    }

    public String getTestCodeReturn(){
        return "KMTEST";
    }
}
