package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.domain.RequestMessage;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    //입장권이 없는 경우 티켓을 구입하고 발급, 입장권이 있는 경우 티켓 발급
    @GetMapping("enter")
    public String enter(@RequestBody RequestMessage requestMessage){
        return theaterService.enter(requestMessage);
    }
}
