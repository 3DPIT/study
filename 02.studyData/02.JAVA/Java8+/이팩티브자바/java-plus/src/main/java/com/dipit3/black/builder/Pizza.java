package com.dipit3.black.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T  addToppping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));

            return self(); // 자기자신인 this를 리턴하면 Builder<T>를 리턴하게 된다. 그럼 사용시 캐스팅을 해야해서 self()를 사용한다.
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {toppings = builder.toppings.clone(); }
}
