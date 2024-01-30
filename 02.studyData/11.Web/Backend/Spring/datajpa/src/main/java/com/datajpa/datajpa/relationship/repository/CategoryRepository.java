package com.datajpa.datajpa.relationship.repository;

import com.datajpa.datajpa.relationship.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
