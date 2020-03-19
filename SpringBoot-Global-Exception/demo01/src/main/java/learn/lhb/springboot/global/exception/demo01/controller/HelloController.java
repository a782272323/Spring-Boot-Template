package learn.lhb.springboot.global.exception.demo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁鸿斌
 * @date 2020/3/20.
 * @time 00:06
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        int i = 1 / 0;
        return "hello";
    }
}
