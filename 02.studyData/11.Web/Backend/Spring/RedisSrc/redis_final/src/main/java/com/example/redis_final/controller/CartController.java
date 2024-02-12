package com.example.redis_final.controller;

import com.example.redis_final.data.CartDao;
import com.example.redis_final.data.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartDao cartDao;


    @PostMapping("/{id}")
    public String save(@PathVariable(name = "id") Long memberId, @RequestBody ItemDto itemDto){
        cartDao.addItem(itemDto, memberId);
        log.info("save cart to cache :" + memberId +" - [" + itemDto + "]");
        return "success caching";
    }

    @GetMapping("/{id}")
    public Object getByMemberId(@PathVariable(name = "id") Long memberId){
        log.info("find cart by member id :" + memberId);
        return cartDao.findByMemberId(memberId);
    }
}
