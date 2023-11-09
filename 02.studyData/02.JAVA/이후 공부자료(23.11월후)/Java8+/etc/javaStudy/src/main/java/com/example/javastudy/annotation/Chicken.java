package com.example.javastudy.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER)// T 제네릭 앞에 사용가능
@Target(ElementType.TYPE_USE)//타입 모든 곳에 사용가능
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
