package learn.lhb.springboot.swagger2.demo01.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import learn.lhb.springboot.swagger2.demo01.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁鸿斌
 * @date 2020/3/22.
 * @time 11:49
 */
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("user")
public class UserController {

    @ApiOperation("添加用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "东莞", required = true)
    })
    @PostMapping("/")
    public String addUser(String username, @RequestParam(required = true) String address) {
        return "添加成功";
    }

    @ApiOperation(("根据ID查询用户的接口"))
    @ApiImplicitParam(name = "id",value = "用户id", defaultValue = "99", required = true)
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        return "成功";
    }

    @PutMapping("/{id}")
    @ApiOperation("根据id更新信息")
    public User updateUserById(@RequestBody User user) {
        return user;
    }
}
