package export001_02;

import expert001_02.AmericaTire;
import expert001_02.Car;
import expert001_02.KoreaTire;
import expert001_02.Tire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.C;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void 자동차_코리아티아어_장착_타이어브랜드_테스트(){
        Tire tire1= new KoreaTire();
        Car car1= new Car(tire1);

        assertEquals("장착된 타이어: 코리아 타이어",car1.getTireBrand());
    }

    @Test
    public void 자동차_미국티아어_장착_타이어브랜드_테스트(){
        Tire tire2= new AmericaTire();
        Car car2= new Car(tire2);

        assertEquals("장착된 타이어: 미국 타이어",car2.getTireBrand());
    }
}
