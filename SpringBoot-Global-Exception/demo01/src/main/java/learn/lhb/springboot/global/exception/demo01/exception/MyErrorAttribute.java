package learn.lhb.springboot.global.exception.demo01.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 梁鸿斌
 * @date 2020/3/20.
 * @time 00:02
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        if ((Integer) map.get("status") == 500) {
            map.put("message", "服务器内部错误");
        }

        return map;
    }
}
