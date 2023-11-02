package coded_oct.functionalCode;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Plus10 plus10 = new Plus10();
        System.out.println( plus10.apply(1));

        //람다 적용
        Function<Integer,Integer> plus10_Lamda = (i)->i+10;
        System.out.println(plus10_Lamda.apply(1));

        Function<Integer,Integer> multiply2 = (i)->i*2;
        System.out.println(multiply2.apply(1));

        //Compose사용
        Function<Integer,Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2)); //multiply2를 먼저 하고 나온 값에 10을 더함

        //andThen
        System.out.println(plus10_Lamda.andThen(multiply2).apply(2));//2를 먼저 10 더하고 그나온 값에 *2;

        //Comsumer
        //타입을 받아 아무것도 리턴하지 않는 함수
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        //Supplier
        //받아올 값을 정의
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        //Predicate
        //어떤한 인자 받아서 true, false리턴
        Predicate<String> startWith3dpit = (s) -> s.startsWith("3dpit");
        Predicate<Integer> isEven = (i) -> i%2 ==0; // And, Or, Negate

        //UnaryOperator
        //입력, 출력 자료형이 같은 경우
        UnaryOperator<Integer> plusUnary = (i)->i+10;
        System.out.println(plusUnary.apply(2));

        //BinaryOperator
        //BiFunction<T,T,T> 3개의 자료혀이 같은 경우
    }
}