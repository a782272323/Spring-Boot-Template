package learn.lhb.springboot.ssm01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring 配置
 * Configuration 注解表示这是一个配置类，作用类似于applicationContext.xml
 * ComponentScan 配置包扫描，属性和 xml属性一样
 *
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 23:19
 */
@Configuration
@ComponentScan(basePackages = "learn.lhb.springboot.ssm01.config",useDefaultFilters = true
    , excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class SpringConfig {
}
