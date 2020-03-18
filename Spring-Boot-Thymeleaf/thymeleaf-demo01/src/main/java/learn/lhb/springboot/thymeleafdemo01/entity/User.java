package learn.lhb.springboot.thymeleafdemo01.entity;

import java.io.Serializable;

/**
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 17:53
 */
public class User implements Serializable {


    private static final long serialVersionUID = -90000065L;

    private Long id;
    private String name;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
