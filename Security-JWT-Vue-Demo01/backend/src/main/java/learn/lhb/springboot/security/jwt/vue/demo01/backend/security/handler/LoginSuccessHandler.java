package learn.lhb.springboot.security.jwt.vue.demo01.backend.security.handler;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.utils.BaseResult;
import learn.lhb.springboot.security.jwt.vue.demo01.backend.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**登录成功
 * @author niXueChao
 * @date 2019/3/12.
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**日志**/
    private static final Logger LOG = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        String userJsonStr = null;
        try {
            userJsonStr = MapperUtils.obj2json(authentication.getPrincipal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("--------userJsonStr = "+userJsonStr);

        //生成token的方法一
        String token = Jwts.builder()
                .setSubject(userJsonStr)
                //设置token有效时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();



        Map<String,Object> map = new HashMap<>();
        map.put("token",token);

        //签发token
        response.getWriter().write(MapperUtils.mapToJson(BaseResult.ok().put(BaseResult.CodeStatus.OK,"登录成功","data",map)));

    }

}
