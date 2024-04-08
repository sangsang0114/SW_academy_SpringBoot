package org.example;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemController {

    @GetMapping("/test")
    String test() {
        return "test";
    }

    @GetMapping("/test2")
    String test2() {
        return "test2";
    }


    @GetMapping("/user")
    ResponseEntity user(@AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(userDetails.getUsername(), HttpStatus.OK);
    }

    @GetMapping("/main")
    String main(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails.getUsername() + "님 메인페이지입니다.";
    }
}

