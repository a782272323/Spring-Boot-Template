package learn.lhb.springboot.httpsdemo01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 15:05
 */
@RestController
public class Test01Controller {

    @RequestMapping("hello")
    public String hello() {
        return "您好";
    }
}
