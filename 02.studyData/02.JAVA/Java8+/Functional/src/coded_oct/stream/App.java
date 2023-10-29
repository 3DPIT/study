package coded_oct.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("3dpit");
        names.add("whiteShip");
        names.add("toby");
        names.add("foo");

        names.forEach(System.out::println);


        Stream<String> stringStream = names.stream().map(String::toUpperCase); //컨베이너 벨트 같은 것
        //중계 오퍼레이터, 터미널 오퍼레이터 있음
        // 차이는 중계의 경우 Stream을 리턴함
        // 종료의 경우 Stream을 리턴하지 않음

        names.stream().map((s)->{ // map의 경우 중계형인데 이경우 터미널 오퍼레이터가 오기 전까지 실행을 안함
            System.out.print(s);
            return s.toUpperCase();
        });

       List<String> collect = names.stream().map((s)->{ //  터미널 오퍼레이터를 명시하면 됨
            System.out.println(s);
            return s.toUpperCase();
        }).collect (Collectors.toList());

     collect.forEach(System.out::println );

       //병렬 처리 - 무조건 빠른건 아니다. 특정 어떤 경우에 따르기 때문에 테스트해봐야 알 듯
        List<String> collect2 =  names.parallelStream().map(String::toUpperCase) .collect(Collectors.toList());
        collect2.forEach(System.out::println);

        //쓰레드 확인
        List<String> collect3=  names.parallelStream().map((s)->{
            System.out.println(s+ " "+ Thread.currentThread().getName());
            return s.toUpperCase();
        }) .collect(Collectors.toList());
        collect2.forEach(System.out::println);

    }
}
