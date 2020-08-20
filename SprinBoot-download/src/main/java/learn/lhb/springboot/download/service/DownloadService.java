package learn.lhb.springboot.download.service;

import learn.lhb.springboot.download.utils.BaseResult;

import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * @Description  业务逻辑层
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/20
 * @time 21:59
 */
public interface DownloadService {

    /**
     * 下载实现方式一
     * @param response
     * @return
     */
    BaseResult downloadDemo01(HttpServletResponse response) throws Exception;
}
