package kr.co.black.mockito.mockitoMain.product;

import kr.co.black.mockito.mockitoMain.product.Product;
import kr.co.black.mockito.mockitoMain.product.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpyAnnotation {

    @Spy
    ProductService productService;

    @Test
    void testStubingX(){
        Product product = productService.getProduct();
        assertThat(product.getSerial()).isEqualTo("KM001");
    }

    @Test
    void testStubingO(){
        Product productDummy = new Product("KM002","IPhone");
         when(productService.getProduct()).thenReturn(productDummy); //여기가 스터빙
         Product product = productService.getProduct();

         assertThat(productDummy.getSerial()).isEqualTo(product.getSerial());
    }
}
