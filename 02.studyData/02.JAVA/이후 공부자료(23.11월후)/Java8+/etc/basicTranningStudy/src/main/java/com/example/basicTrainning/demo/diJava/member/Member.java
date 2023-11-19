package com.example.basicTrainning.demo.diJava.member;


public class Member {

    private Long id;

    private String name;

    private Grade grede;

    public Member(Long id, String name, Grade grede) {
        this.id = id;
        this.name = name;
        this.grede = grede;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grade getGrede() {
        return grede;
    }

    public void setGrede(Grade grede) {
        this.grede = grede;
    }


}
