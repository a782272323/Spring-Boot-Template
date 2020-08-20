package learn.lhb.springboot.download.controller;

import com.sun.deploy.net.HttpResponse;
import learn.lhb.springboot.download.service.DownloadService;
import learn.lhb.springboot.download.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description  控制层
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/20
 * @time 21:59
 */
@RestController
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    /**
     * 下载实现方式一
     * @return
     */
    @GetMapping("/download/demo-01")
    public BaseResult downloadDemo01(HttpServletResponse response)throws Exception {
        return downloadService.downloadDemo01(response);
    }
}
