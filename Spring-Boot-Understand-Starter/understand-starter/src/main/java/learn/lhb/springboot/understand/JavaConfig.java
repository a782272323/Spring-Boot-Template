package learn.lhb.springboot.understand;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 面条和米饭配置类
 *
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 00:10
 */
@Configuration
public class JavaConfig {

    @Bean("food")
    @Conditional(RiceCondition.class)
    Food rice() {
        return new Rice();
    }

    @Bean("food")
    @Conditional(NoodlesCondition.class)
    Food noodles() {
        return new Noodles();
    }
}
