package learn.lhb.springboot.understand;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 条件类
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 00:08
 */
public class NoodlesCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("people").equals("北方人");
    }
}
