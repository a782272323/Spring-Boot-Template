package learn.lhb.springboot.lhb.master;

/**
 * @author 梁鸿斌
 * @date 2020/3/17.
 * @time 01:04
 */
public class HelloService {
    private String msg;
    private String name;
    public String sayHello() {
        return name + " say " + msg + " ！";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
