package coded_oct.methodRef;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {

        //static 메소드 사용법
        UnaryOperator<String> hi = (s) -> "hi" + s;
        //==
        UnaryOperator<String> hiMethodRef = Greeting::hi;


        //객체 레퍼런스, 인스턴스 메소드 사용법
        Greeting greeting = new Greeting();
        UnaryOperator<String> helloMethodRef = greeting::hello;
        //Supplier적용
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();

        //타입 new
        Function<String, Greeting> dp3Greeting = Greeting::new;
        //        Supplier<Greeting> newGreeting = Greeting::new;
        // 이거랑 같음 new 쓰지만 다른 생성자 사용.
        Greeting _3dpit = dp3Greeting.apply("3dpit");
        System.out.println(_3dpit.getName());

        //인스턴스 메소드 사용법
        String[] names ={"n","b","a"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}

