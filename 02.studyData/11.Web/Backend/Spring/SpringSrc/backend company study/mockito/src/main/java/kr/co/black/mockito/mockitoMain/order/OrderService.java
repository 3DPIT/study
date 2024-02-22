package kr.co.black.mockito.mockitoMain.order;

import kr.co.black.mockito.mockitoMain.product.ProductService;
import kr.co.black.mockito.mockitoMain.product.Product;
import kr.co.black.mockito.mockitoMain.user.User;
import kr.co.black.mockito.mockitoMain.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    UserService userService;
    ProductService productService;

    OrderService(UserService userService, ProductService productService){
        this.userService = userService;
        this.productService = productService;
    }

    public User getUser(){
        return userService.getUser();
    }

    public Product getProdut(){
        return productService.getProduct();
    }

}
