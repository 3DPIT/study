import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll //전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 statc이어야 한다.
     static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스를 시작하기 전 마다 실행
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterAll //전체 테스트를 마치고 나서 1회 실행하므로 메서드는 statc이어야 한다.
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    @AfterEach//테스트 종료하기 전 1회 실행
    public void afterEach(){
        System.out.println("@AfterEach");
    }
}
