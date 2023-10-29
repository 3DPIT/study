package coded_oct.lamdaCode;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<Integer> plus10 = (i) -> i +10;

        BiFunction<Integer,Integer,Integer> biFunction= (a,b)-> a+b;
        BiFunction<Integer,Integer,Integer> biFunction1= (Integer a,Integer b)-> a+b; //타입 지정안해도 추론,
        // 1개일 경우 {return} 없애고 그냥 출력
    }

    private void run(){
        final int baseNumber= 10; //자바8부터 어디서 변경하지 않는 경우 사실상 파이널
        // 즉, Manual, java doc에서 effective final이라고하는데

        //로컬 클래스
        class LocalClass{
            void printBaseNumber(){
                int baseNumber= 11;
                System.out.println(baseNumber);
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };
        //위에는 쉐도잉이 적요됨

        //람다
        IntConsumer printInt = (i)->{
            System.out.println(i+baseNumber);
        };

//        IntConsumer printInt = (baseNumber)->{
//            System.out.println(i+baseNumber);
//        };
//  람다를 감싸고 있는 것과 스콥이 같으므로 쉐도잉도 안되고, 같음 변수 못씀
        printInt.accept(10);
    }
}
