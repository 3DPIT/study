package stream.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot", true));
        springClasses.add(new OnlineClass(2,"spring data jpa", true));
        springClasses.add(new OnlineClass(3,"spring mvc", false));
        springClasses.add(new OnlineClass(4,"spring core", false));
        springClasses.add(new OnlineClass(5,"rest api development", false));

        System.out.println("spring으로 시작하는 수업");
        springClasses.stream()
                .filter(oc->oc.getTitle().startsWith("spring"))
                .forEach(oc->System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
                .filter(oc -> !oc.isClosed())
                .forEach(oc->System.out.println(oc.getTitle()));
        //단축시키기
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc->System.out.println(oc.getTitle()));

        System.out.println("수업 이름만 모아서 스트림 만들기 ");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6,"The Java, Test",true));
        javaClasses.add(new OnlineClass(7,"The Java, Code manipulation",true));
        javaClasses.add(new OnlineClass(8,"The Java, 8 to 11",false));

        List<List<OnlineClass> > dpit3Event = new ArrayList<>();
        dpit3Event.add(springClasses);
        dpit3Event.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        dpit3Event.stream().flatMap(Collection::stream)
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i-> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        javaClasses.stream().allMatch(oc->oc.getTitle().contains("Test"));

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제모만 모아서 List로 만들기1");
        List<String> spring1 =  springClasses.stream()
                .filter(oc->oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());

        spring1.forEach(System.out::println);

        //또는
        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제모만 모아서 List로 만들기2");
        List<String> spring2 =  springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(t-> t.contains("sprin이전 재생g"))
                .collect(Collectors.toList());

        spring2.forEach(System.out::println);

    }
}
