package com.dipit3.black.memberapi.api;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller @ResponseBody를 합친것
@RequiredArgsConstructor
public class MemberApiController {

//    private final MemberService memberService;
//
//    @PostMapping("/api/v1/members")
//    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
//
//    }
//
//    @Data
//    static class CreateMemberResponse {
//        private Long id;
//    }

}
