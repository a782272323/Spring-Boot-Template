package learn.lhb.springboot.security.jwt.vue.demo01.backend.service.impl;

import learn.lhb.springboot.security.jwt.vue.demo01.backend.entity.JwtUser;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.security.filter.JwtLoginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * UserDetailsService的实现
 *
 * JwtAuthenticationProvider在进行登录信息校验是就会通过它查询用户信息
 */
@Component
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;


    private JwtLoginFilter jwtLoginFilter;


    /**日志**/
    private static final Logger LOG = LoggerFactory.getLogger(JwtUserDetailServiceImpl.class);

    @Lazy(true)
    @Autowired
    public JwtUserDetailServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 数据库查询
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("JwtUserDetailServiceImpl = "+username);
        if ("admin".equals(username)) {
            return new JwtUser("admin", passwordEncoder.encode("123456"));
        }
        if ("user".equals(username)) {
            return new JwtUser("user", passwordEncoder.encode("123456"));
        }
        return null;

    }
}