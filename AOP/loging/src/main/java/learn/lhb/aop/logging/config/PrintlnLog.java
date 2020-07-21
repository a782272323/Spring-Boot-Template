package learn.lhb.aop.logging.config;

import java.lang.annotation.*;

/**
 * @Description  自定义注解 PrintlnLog
 * @author Herbie Leung
 * @date 2020/7/21
 * @time 09:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface PrintlnLog {

    /**
     * 自定义日志描述信息文案
     * @return
     */
    String description() default "";
}
