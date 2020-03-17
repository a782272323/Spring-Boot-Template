package learn.lhb.springboot.understand;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 启动测试类
 * @author 梁鸿斌
 * @date 2020/3/18.
 * @time 00:12
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 加载java配置类
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // 添加一个属性到environment中
        ctx.getEnvironment().getSystemEnvironment().put("people", "南方人");
        // 注册配置类
        ctx.register(JavaConfig.class);
        // 刷新容器
        ctx.register();
        // 从spring容器中获取Food实例
        Food food = (Food) ctx.getBean("food");
        // 输出结果
        System.out.println(food.showName());
    }
}
