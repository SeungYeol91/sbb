package com.ll.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
@GetMapping("/")
    public String root() {
        return "redirect:/question/list"; // 접속 시 /question/list로 연결
    }
}
