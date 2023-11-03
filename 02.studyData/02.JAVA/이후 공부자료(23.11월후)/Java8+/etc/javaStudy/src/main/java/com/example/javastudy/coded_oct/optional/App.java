package com.example.javastudy.coded_oct.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot", true));
        springClasses.add(new OnlineClass(2,"spring data jpa", true));
        springClasses.add(new OnlineClass(3,"spring mvc", false));
        springClasses.add(new OnlineClass(4,"spring core", false));
        springClasses.add(new OnlineClass(5,"rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean preent = spring.isPresent();
        System.out.println(preent);

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        optional.ifPresent(oc->System.out.println(oc.getTitle()));

        //뭔가 더 작엉을 하고 싶다 하면
        OnlineClass onlineClass = optional.orElse(createNewClass());
        System.out.println(onlineClass.getTitle());

        OnlineClass onlineClass2= optional.orElseGet(App::createNewClass);//동적으로 무언가 만들고 싶을때
        System.out.println(onlineClass2.getTitle());


        //flatMap  map으로 하면 두번 까는거 한번만 깜
        Optional<Progress> progress =  optional.flatMap(OnlineClass::getProgress);

        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElseThrow();

    }
        private static OnlineClass createNewClass(){
            System.out.println("creating new online class");
            return new OnlineClass(10,"New class", false);
        }
}
