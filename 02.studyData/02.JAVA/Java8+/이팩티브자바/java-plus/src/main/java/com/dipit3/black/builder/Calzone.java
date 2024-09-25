package com.dipit3.black.builder;

public class Calzone extends Pizza{

    private final boolean sauceInside;

    public Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder>{
        private boolean sauceInside = false;

        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build(){
            return new Calzone(this);
        }

        @Override
        protected Builder self(){return this;}
    }

    @Override
    public String toString() {
        return String.format("%s로 토핑한 칼초네 피자 (소스는 %s에)", toppings, sauceInside ? "안" : "바깥");
    }
}
