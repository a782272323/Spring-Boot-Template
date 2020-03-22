package learn.lhb.springboot.swagger2.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 梁鸿斌
 * @date 2020/3/22.
 * @time 11:29
 */
@SpringBootApplication
@EnableSwagger2
public class Swagger2Demo01Application {
    public static void main(String[] args) {
        SpringApplication.run(Swagger2Demo01Application.class, args);
    }
}
