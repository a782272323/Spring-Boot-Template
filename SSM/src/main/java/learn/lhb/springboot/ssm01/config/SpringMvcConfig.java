package learn.lhb.springboot.ssm01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * SpringMVC 配置
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 23:23
 */
@Configuration
@ComponentScan(basePackages = "learn.lhb.springboot.ssm01.config",useDefaultFilters = false
 ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
public class SpringMvcConfig {
}
