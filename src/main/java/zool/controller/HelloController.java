package zool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index2")
public class HelloController {

    @RequestMapping("/index2")
    public String hello(){
        System.out.println("nihao");
        return "index2";
    }

}
