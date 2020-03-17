package learn.lhb.springboot.understand;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 00:17
 */
@Configuration
public class JavaConfig1 {

    @Bean("food")
    @Profile("南方人")
    Food rice() {
        return new Rice();
    }

    @Bean("food")
    @Profile("北方人")
    Food noodles() {
        return new Noodles();
    }
}
