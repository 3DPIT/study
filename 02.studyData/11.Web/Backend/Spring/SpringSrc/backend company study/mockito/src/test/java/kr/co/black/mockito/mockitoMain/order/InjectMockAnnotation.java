package kr.co.black.mockito.mockitoMain.order;

import kr.co.black.mockito.mockitoMain.order.OrderService;
import kr.co.black.mockito.mockitoMain.product.Product;
import kr.co.black.mockito.mockitoMain.product.ProductService;
import kr.co.black.mockito.mockitoMain.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class InjectMockAnnotation {

    @Mock
    UserService userService;
    @Spy
    ProductService productService;
    @InjectMocks
    OrderService orderService;

    @Test
    void testGetUser(){
        assertNull(orderService.getUser());
    }

    @Test
    void testGetProduct(){
        Product product =orderService.getProdut();

        assertThat(product.getSerial()).isEqualTo("KM001");
    }
}
