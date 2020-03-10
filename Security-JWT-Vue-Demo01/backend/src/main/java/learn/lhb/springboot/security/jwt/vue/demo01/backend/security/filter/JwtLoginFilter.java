package learn.lhb.springboot.security.jwt.vue.demo01.backend.security.filter;


import learn.lhb.springboot.security.jwt.vue.demo01.backend.service.impl.JwtUserDetailServiceImpl;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.utils.BaseResult;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JwtLoginFilter
 * 自定义的登录过滤器，把它加到SpringSecurity的过滤链中，拦截登录请求
 * 1.设置登录的url，请求的方式==定义这个过滤器要拦截哪个请求
 * 2.调用JwtAuthenticationProvider进行登录校验
 * 3.校验成功调用LoginSuccessHandler，校验失败调用LoginSuccessHandler
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {



    private JwtUserDetailServiceImpl jwtUserDetailService;

    /**日志**/
    private static final Logger LOG = LoggerFactory.getLogger(JwtLoginFilter.class);


    public JwtLoginFilter() {
        /**
         * AntPathRequestMatcher
         * URL拦截
         */
        super(new AntPathRequestMatcher("/user/login", "POST"));
    }


    /**
     * 拦截登录请求，具体url设置看上面，
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException 抛出异常，LoginFailureHandler捕获异常
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LOG.info("--------------------------------------------");
            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            //创建未认证的凭证(etAuthenticated(false)),注意此时凭证中的主体principal为用户名
            JwtLoginToken jwtLoginToken = new JwtLoginToken(userName, password);
            //将认证详情(ip,sessionId)写到凭证
            jwtLoginToken.setDetails(new WebAuthenticationDetails(request));
            //AuthenticationManager获取受支持的AuthenticationProvider(这里也就是JwtAuthenticationProvider),
            //生成已认证的凭证,此时凭证中的主体为userDetails
            Authentication authenticatedToken = this.getAuthenticationManager().authenticate(jwtLoginToken);
            LOG.info("拦截成功，并生成已经认证的凭证");
            return authenticatedToken;
        } catch (Exception e) {
            e.printStackTrace();

            throw new BadCredentialsException(MapperUtils.mapToJson(BaseResult.error("用户名或者密码错误")));
        }

    }



}