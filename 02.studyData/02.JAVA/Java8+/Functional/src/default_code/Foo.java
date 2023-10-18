package default_code;

public interface Foo {

    void printName();

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNAmeUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();
}
