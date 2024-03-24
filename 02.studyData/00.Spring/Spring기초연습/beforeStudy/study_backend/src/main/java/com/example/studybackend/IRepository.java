package com.example.studybackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<Entity1, Long> {
}
