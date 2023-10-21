package me._3dpit.java8to11;

@FunctionalInterface
public interface RunSomething {
    void doIt(); //하나의 추상메소드만 있어야 함수형임

    static void printName(){
        System.out.println("3dpit");
    }

    default  void printAge(){
        System.out.println(10);
    }
}
