package StaticMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("123");
        name.add("234");
        name.add("345");
        name.add("456");

//        name.forEach(s ->{
//            System.out.println(s);
//        });
        name.forEach(System.out::println);

        for(String n: name){
            System.out.println(n);
        }

        Spliterator<String> spliterator = name.spliterator();
        spliterator.trySplit();//절반 쪼개는 소스
        while(spliterator.tryAdvance(System.out::println));


        //아래와 같이 두개 쪼개는 경우 사용
        Spliterator<String> stringSpliterator1 = name.spliterator();
        Spliterator<String> stringSpliterator2 = stringSpliterator1.trySplit();
        while(stringSpliterator1.tryAdvance(System.out::println));
        System.out.println("-----------------");
        while(stringSpliterator2.tryAdvance(System.out::println));


        //stream사용
        long k = name.stream().map(String::toUpperCase)
                .filter(s->s.startsWith("1"))
                .count();

        //모아오는 것등 가능
        name.stream().map(String::toUpperCase)
                .filter(s->s.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(k);

        //removeIf
        name.removeIf(s->s.startsWith("1"));
        name.forEach(System.out::println);

        //Commpare
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase);//정순
        name.sort(compareToIgnoreCase.reversed());//역순
        //다른 조건으로 하고 싶은 경우 thenComparing()하면됨


    }
}
