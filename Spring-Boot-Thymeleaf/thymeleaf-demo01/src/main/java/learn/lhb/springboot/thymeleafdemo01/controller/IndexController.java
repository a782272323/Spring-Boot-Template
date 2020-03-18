package learn.lhb.springboot.thymeleafdemo01.controller;

import learn.lhb.springboot.thymeleafdemo01.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 17:51
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId((long) i);
            u.setName("梁鸿斌: "+i);
            u.setAddress("东莞: " + i);
            users.add(u);
        }
        model.addAttribute("users", users);
        return "index";
    }
}
