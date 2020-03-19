package learn.lhb.springboot.security.jwt.vue.demo01.backend.controller;

import learn.lhb.springboot.security.jwt.vue.demo01.backend.dto.LoginInfo;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.utils.BaseResult;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 梁鸿斌
 * @date 2020/3/10.
 * @time 17:04
 */
@RestController
@RequestMapping("user")
public class LoginController {


    @GetMapping("info")
    public BaseResult info(Authentication authentication) {

        System.out.println(authentication.getName());
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(authentication.getName());
        loginInfo.setAvatar(null);
        return BaseResult.ok().put(20000, "获取用户信息成功", "data", loginInfo);
    }

    @PostMapping("logout")
    public BaseResult logout(HttpServletRequest request) {
        System.out.println("前后交互成功!");
//        String token = request.getParameter("Authentication");
//        System.out.println(token);
        return BaseResult.ok();

    }
}
