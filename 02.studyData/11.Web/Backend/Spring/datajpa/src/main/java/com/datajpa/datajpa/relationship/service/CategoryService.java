package com.datajpa.datajpa.relationship.service;

import com.datajpa.datajpa.relationship.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    public Category getCategory(Long categoryId);
}
