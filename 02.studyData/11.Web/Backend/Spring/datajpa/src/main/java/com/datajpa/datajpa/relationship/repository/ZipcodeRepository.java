package com.datajpa.datajpa.relationship.repository;

import com.datajpa.datajpa.relationship.model.Zipcode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepository extends CrudRepository<Zipcode, Long> {
}
