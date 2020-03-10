package learn.lhb.springboot.security.jwt.vue.demo01.backend.security.config;


import learn.lhb.springboot.security.jwt.vue.demo01.backend.security.filter.JwtHeadFilter;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.security.filter.JwtLoginFilter;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.security.handler.LoginFailureHandler;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.security.handler.LoginSuccessHandler;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.security.provider.JwtAuthenticationProvider;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.service.impl.JwtUserDetailServiceImpl;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.utils.BaseResult;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @author niXueChao
 * @date 2019/4/2 22:58.
 */
@Configuration
public class ApplicationConfigurerAdapter extends WebSecurityConfigurerAdapter {


    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登录过滤器
        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter();
        jwtLoginFilter.setAuthenticationManager(this.authenticationManagerBean());

        //登录成功和失败的操作
        LoginSuccessHandler loginSuccessHandler = new LoginSuccessHandler();
        jwtLoginFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
        jwtLoginFilter.setAuthenticationFailureHandler(new LoginFailureHandler());

        //登录过滤器的授权提供者(就这么叫吧)
        JwtAuthenticationProvider provider = new JwtAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(jwtUserDetailService);


        //JWT校验过滤器
        JwtHeadFilter headFilter = new JwtHeadFilter();

        http
                //身份验证入口,当需要登录却没登录时调用
                //具体为,当抛出AccessDeniedException异常时且当前是匿名用户时调用
                //匿名用户: 当过滤器链走到匿名过滤器(AnonymousAuthenticationFilter)时,
                //会进行判断SecurityContext是否有凭证(Authentication),若前面的过滤器都没有提供凭证,
                //匿名过滤器会给SecurityContext提供一个匿名的凭证(可以理解为用户名和权限为anonymous的Authentication),
                //这也是JwtHeadFilter发现请求头中没有jwtToken不作处理而直接进入下一个过滤器的原因
            .cors().and()
            .exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(MapperUtils.mapToJson(BaseResult.error("请您登录")));
        })

                //拒绝访问处理,当已登录,但权限不足时调用
                //抛出AccessDeniedException异常时且当不是匿名用户时调用
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write(MapperUtils.mapToJson(BaseResult.error("权限不足")));
                })
                .and()
                .authorizeRequests()

                .anyRequest().access("@accessDecisionService.hasPermission(request , authentication)")
                .and()
                //将授权提供者注册到授权管理器中(AuthenticationManager)
                .authenticationProvider(provider)
                .addFilterAfter(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(headFilter, JwtLoginFilter.class)
                //禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
