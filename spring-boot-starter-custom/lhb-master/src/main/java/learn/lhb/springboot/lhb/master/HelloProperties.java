package learn.lhb.springboot.lhb.master;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 梁鸿斌
 * @date 2020/3/17.
 * @time 00:56
 */
@ConfigurationProperties(prefix = "lhb")
public class HelloProperties {
    private static final String DEFAULT_NAME = "梁鸿斌";
    private static final String DEFAULT_MSG = "自学男孩";
    private String name = DEFAULT_NAME;
    private String msg = DEFAULT_MSG;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
