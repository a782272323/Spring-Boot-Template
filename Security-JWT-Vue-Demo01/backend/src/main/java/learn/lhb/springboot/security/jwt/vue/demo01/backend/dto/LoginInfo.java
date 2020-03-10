package learn.lhb.springboot.security.jwt.vue.demo01.backend.dto;

import java.io.Serializable;

/**
 * @author 梁鸿斌
 * @date 2020/3/10.
 * @time 17:23
 */
public class LoginInfo implements Serializable {

    private String name;
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
