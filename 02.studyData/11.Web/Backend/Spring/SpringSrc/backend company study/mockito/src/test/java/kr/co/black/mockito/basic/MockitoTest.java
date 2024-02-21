package kr.co.black.mockito.basic;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

public class MockitoTest {

    @Test
    public void mockAndStubTest(){
        //Mock객체 생성 - Mock - null의 값을 가지는리스트 생성
        List<String> mockList = Mockito.mock(List.class);

        //Mock 객체의 동작 정의
        //:Stub - Mock 객체의 사이즈를 항상 10으로 반환하도록 예상 동작 설정
        Mockito.when(mockList.size()).thenReturn(10);

        //Mock 객체 사용
        //Mock 객체의 메소드 호출
        int size = mockList.size();

        //결과 확인
        assertThat(size).isEqualTo(10);
    }

    @Test
    public void spyTest(){
        //실제 객체 생성
        List<String> originList = new ArrayList<>();

        //Spy 객체 생성 - Spy 실제 객체의 원본을 유지하며 객체를 생성
        List<String> spyList = Mockito.spy(originList);

        //Spy 객체의 메서드 동작 정의 - Spy 이러한 객체에 값을 지정
        Mockito.doReturn("Mocked").when(spyList).get(0);

        //Spy 객체 사용
        String element = spyList.get(0);

        assertThat(element).isEqualTo("Mocked");
    }

    @Test
    public void mockingTest(){
        //Mockito를 사용한 모의 객체 생성 예시
        ExampleClass mockExample = Mockito.mock(ExampleClass.class);

        //모의 객체의 동작을 메소드의 반환 값으로 지정
        Mockito.when(mockExample.getData()).thenReturn("Mocked data");

        //모의 객체 사용 테스트
        String result = mockExample.getData();

        //모의 객체의 메소드 호출 확인
        Mockito.verify(mockExample,times(1)).getData();

        //출력 데이터 확인
        assertThat(result).isEqualTo("Mocked data");
    }

    public class ExampleClass{
        public String getData(){
            return "Real data";
        }
    }

    @Test
    public void verifyTest(){
        VerifyExampleClass mockExample = Mockito.mock(VerifyExampleClass.class);

        //메소드 호출
        mockExample.methodA();
        mockExample.methodB();

        //메소드 호출 확인
        Mockito.verify(mockExample).methodA();
        Mockito.verify(mockExample).methodB();

        //메소드 호출 순서 확인
        InOrder inOrder = Mockito.inOrder(mockExample);
        inOrder.verify(mockExample).methodA();
        inOrder.verify(mockExample).methodB();

        /*
        //반대로 하는 경우 테스트 실패함
        inOrder.verify(mockExample).methodB();
        inOrder.verify(mockExample).methodA();
         */
    }

    public class VerifyExampleClass{
        public void methodA(){

        }
        public void methodB(){

        }
    }
}
