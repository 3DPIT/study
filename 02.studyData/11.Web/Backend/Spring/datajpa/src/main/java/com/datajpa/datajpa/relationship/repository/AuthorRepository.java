package com.datajpa.datajpa.relationship.repository;

import com.datajpa.datajpa.relationship.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
