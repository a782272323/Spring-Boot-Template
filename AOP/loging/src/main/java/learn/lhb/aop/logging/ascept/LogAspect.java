package learn.lhb.aop.logging.ascept;

import com.alibaba.fastjson.JSON;
import learn.lhb.aop.logging.config.PrintlnLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author Herbie Leung
 * @Description 切面类
 * @date 2020/7/21
 * @time 09:37
 */
@Aspect
@Component
//@Profile({"dev"}) // 对某个环境(dev,prod,test)打日志
public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 以自定义 @PrintlnLog 注解作为切面入口
     */
    @Pointcut("@annotation(learn.lhb.aop.logging.config.PrintlnLog)")
    public void PrintlnLog() {
    }

    /**
     * 切面方法入参日志打印
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("PrintlnLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 方法开始
        String methodDetailDescription = this.getAspectMethodLogDescJP(joinPoint);
        log.info("------------------------------- 日志开始 --------------------------");
        // 打印自定义方法描述
        log.info("方法详情描述 : {}", methodDetailDescription);
        // 打印请求入参
        log.info("请求参数 : {}", JSON.toJSONString(joinPoint.getArgs()));
        // 打印请求方式
        log.info("请求方法 : {}", request.getMethod());
        // 打印请求 url
        log.info("请求地址 : {}", request.getRequestURL().toString());
        // 打印调用方法全路径以及执行方法
        log.info("请求的类和方法 : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    /**
     * 切面方法返回结果日志打印
     * @param proceedingJoinPoint
     */
    @Around("PrintlnLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String aspectMethodLogDescPJ = getAspectMethodLogDescPJ(proceedingJoinPoint);
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 输出结果
        log.info("{}，输出结果 : {}", aspectMethodLogDescPJ, JSON.toJSONString(result));

        // 方法执行耗时
        log.info("方法耗时 : {} ms", System.currentTimeMillis() - startTime);

        return result;
    }

    /**
     * 切面方法执行后执行
     * @param joinPoint
     */
    @After("PrintlnLog()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("------------------------------- 日志结束 --------------------------" + LINE_SEPARATOR);
    }

    /**
     * 注解作用的切面方法详细细信息
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public String getAspectMethodLogDescJP(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * 注解作用的切面方法详细细信息
     * @param proceedingJoinPoint
     * @return
     * @throws Exception
     */
    public String getAspectMethodLogDescPJ(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        String targetName = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] arguments = proceedingJoinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * 自定义注解参数
     * @param targetName
     * @param methodName
     * @param arguments
     * @return
     * @throws Exception
     */
    public String getAspectMethodLogDesc(String targetName, String methodName, Object[] arguments) throws Exception {
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuffer description = new StringBuffer("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                description.append(method.getAnnotation(PrintlnLog.class).description());
                break;
            }
        }
        return description.toString();
    }
}
