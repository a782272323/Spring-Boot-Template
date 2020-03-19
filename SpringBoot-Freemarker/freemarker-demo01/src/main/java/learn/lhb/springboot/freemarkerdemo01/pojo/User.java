package learn.lhb.springboot.freemarkerdemo01.pojo;

import java.io.Serializable;

/**
 * @author 梁鸿斌
 * @date 2020/3/19.
 * @time 12:53
 */
public class User implements Serializable {


    private static final long serialVersionUID = -90031722L;

    private Long id;
    private String username;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

