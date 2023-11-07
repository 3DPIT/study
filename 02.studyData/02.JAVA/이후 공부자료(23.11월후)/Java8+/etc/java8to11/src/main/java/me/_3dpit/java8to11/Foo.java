package me._3dpit.java8to11;

public class Foo{
    public static void main(String[] args) {
        //익명 내부 클래스 anonymous inner class
        RunSomething runSomething = () -> System.out.println("3dpit"); //람다 표현식
/*
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("3dpit");
            }
        };
*/
    }
}
