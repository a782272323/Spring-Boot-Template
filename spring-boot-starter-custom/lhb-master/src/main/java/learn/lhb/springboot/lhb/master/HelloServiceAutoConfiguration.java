package learn.lhb.springboot.lhb.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 梁鸿斌
 * @date 2020/3/17.
 * @time 01:07
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    @Bean
    HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setName(helloProperties.getName());
        helloService.setMsg(helloProperties.getMsg());
        return helloService;
    }
}
