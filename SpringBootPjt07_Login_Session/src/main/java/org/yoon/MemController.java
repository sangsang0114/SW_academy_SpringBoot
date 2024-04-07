package org.yoon;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemController {

    @Autowired
    MemService memService;

    // 로그인 성공하면 세션에 정보 저장.
    @PostMapping("/login")
    String login(@RequestBody Mem mem, HttpSession session) {
        Mem loginMem = memService.login(mem);
        if (loginMem != null) {   // 로그인 성공하면 세션에 정보 저장.

            session.setAttribute("loginuser", loginMem);

            return loginMem.getMem_nm() + " 님 로그인 성공";
        } else return "로그인 실패";
    }


    // 로그인한 경우만 접근 가능한 페이지  (세션에 사용자 정보가 있는 경우 로그인)
    @GetMapping("/main")
    String main(Mem mem, HttpSession session) {

        Mem loginMem = (Mem) session.getAttribute("loginuser");
        if (loginMem != null) { // 로그인한 사용자는 Main 페이지를 볼 수 있다.
            return "Main 페이지";

        } else return "로그인한 후에만 볼 수 있는 페이지입니다. ";
    }


    // 로그 아웃 하면 세션에 사용자 정보를 삭제합니다.
    @GetMapping("/logout")
    String login(HttpSession session) {

        session.removeAttribute("loginuser");
        return "로그 아웃";
    }
}
