package learn.lhb.springboot.ssm01.init;

import learn.lhb.springboot.ssm01.config.SpringMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 相当于 web.xml
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 23:25
 */
public class WebInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        // 加载 SpringMVC 的配置文件
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);

        // 添加 DispatcherServlet
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(ctx));

        // 给 DispatcherServlet 配置路径映射
        springmvc.addMapping("/");

        // 给 DispatcherServlet 添加启动时机
        springmvc.setLoadOnStartup(1);

        System.out.println("项目启动了!!!!");
    }


}
