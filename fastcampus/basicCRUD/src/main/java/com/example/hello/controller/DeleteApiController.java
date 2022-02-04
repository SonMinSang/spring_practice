package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class DeleteApiController {

    @DeleteMapping("/delete/{userId}") //Object로 받을수는 있지만 하나하나 작성하여 삭제하는 것이 좋음
    public void delete(@PathVariable String userId, @RequestParam String account){
        System.out.println(userId);
        System.out.println(account);
    }


}
