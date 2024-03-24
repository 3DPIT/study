package com.example.studybackend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class Controller {

    private final ServiceImpl service;

    @PostMapping("/entity")
    public ResponseEntity<Entity1> save(@RequestBody Entity1 req){
        Entity1 entity = service.save(req);
        return ResponseEntity.ok().body(entity);
    }

}
