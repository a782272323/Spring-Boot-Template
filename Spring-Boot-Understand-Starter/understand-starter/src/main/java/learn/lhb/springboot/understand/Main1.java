package learn.lhb.springboot.understand;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用Profile注解
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 00:18
 */
public class Main1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("南方人");
        ctx.register(JavaConfig1.class);
        ctx.refresh();
        Food food = (Food) ctx.getBean("food");
        System.out.println(food.showName());
    }
}
