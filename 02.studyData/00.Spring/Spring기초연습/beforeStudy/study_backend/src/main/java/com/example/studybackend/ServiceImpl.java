package com.example.studybackend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ServiceImpl implements IService {

    private final IRepository repository;

    @Override
    public Entity1 save(Entity1 entity) {
       repository.save(entity);

       return entity;
    }

    @Override
    public Entity1 findById(Long id) {
        Entity1 entity = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("id X"));
        return entity;
    }
}
