package learn.lhb.springboot.ssm01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 23:29
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("1111111");
        return "hello";
    }
}
