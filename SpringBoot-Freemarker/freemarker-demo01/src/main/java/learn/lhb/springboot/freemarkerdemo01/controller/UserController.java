package learn.lhb.springboot.freemarkerdemo01.controller;

import learn.lhb.springboot.freemarkerdemo01.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/3/19.
 * @time 12:54
 */
@Controller
public class UserController {
    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setUsername("梁鸿斌>>>>>"+i);
            user.setAddress("你好" + i);
            users.add(user);
        }
        model.addAttribute("users", users);
        return "index";
    }
}
