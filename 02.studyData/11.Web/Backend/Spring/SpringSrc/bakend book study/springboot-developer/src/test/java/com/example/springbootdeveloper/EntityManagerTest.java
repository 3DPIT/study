package com.example.springbootdeveloper;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityManagerTest {

    @Autowired
    EntityManager em;

    @Test
    public void example() {
        Member member = new Member(1L, "BLACK");  //엔티티 매니저가 엔티티를 관리하지 않는 상태(비영속 상태)
        em.persist(member); //엔티티가 관리되는 상태
        em.detach(member);  //엔티티 객체가 분리된 상태
        em.remove(member);  //엔티티 객체가 삭제된 상태
    }
}
