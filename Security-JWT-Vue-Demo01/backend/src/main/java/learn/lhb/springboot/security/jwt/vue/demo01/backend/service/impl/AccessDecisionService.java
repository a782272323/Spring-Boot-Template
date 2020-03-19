package learn.lhb.springboot.security.jwt.vue.demo01.backend.service.impl;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 配置路径访问限制,若你的用户角色比较简单,不需要存数据库,
 * 可以在ApplicationConfigurerAdapter里配置如
 * httpSecurity
 * .authorizeRequests()
 * .antMatchers("/order").....
 *
 * @author niXueChao
 * @date 2019/4/10 10:33.
 */
@Component("accessDecisionService")
public class AccessDecisionService {


    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 不被拦截的路径
        for (String url : Arrays.asList("/v1/login")) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }

        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 根据用户名查出拥有哪些权限
        List<String> urls = queryUrlByUserName(userDetails.getUsername());
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 这里模拟数据库查询用户权限
     */
    private List<String > queryUrlByUserName(String username) {
        switch (username) {
            case "admin":
                return Arrays.asList("/innerMsg", "/secret","/user/info","/user/logout");
            case "user":
                return Arrays.asList("/innerMsg");
            default:
                return new ArrayList<>();
        }
    }
}