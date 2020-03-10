package learn.lhb.springboot.security.jwt.vue.demo01.backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁鸿斌
 * @date 2020/3/10.
 * @time 12:52
 */
@RestController
public class TestController {

    @GetMapping("/publicMsg")
    public String getMsg() {
        return "不需要登录验证就可以访问的资源";
    }

    @GetMapping("/innerMsg")
    public String innerMsg(Authentication authentication) {
        return "欢迎您!";
    }

    @GetMapping("/secret")
    public String secret(Authentication authentication) {
        return "欢迎您，管理员";
    }
}
