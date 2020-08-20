package learn.lhb.springboot.download.service.impl;

import learn.lhb.springboot.download.service.DownloadService;
import learn.lhb.springboot.download.utils.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @Description  实现类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/20
 * @time 22:00
 */
@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 下载实现方式一
     * @param response
     * @return
     */
    @Override
    public BaseResult downloadDemo01(HttpServletResponse response) throws Exception{
        String fileName = "通讯录批量导入模版";
        String fileType = ".xlsx";
        String filePath = "excel";
        // 文件流
        System.out.println(filePath + "/" + fileName + fileType);
//        File file = new File(filePath + "/" + fileName + fileType);
        File file = new File("/Learing Materials/Programming Language/GItLab Code/Monomer Project Practice/Spring-Boot-Template/SprinBoot-download/excel/通讯录批量导入模板.xlsx");
        // 如果文件不存在
        if (!file.exists()) {
            System.out.println("找不到该文件 + " + fileName + fileType);
            return BaseResult.error("找不到该文件 + " + fileName + fileType);
        }
        // 文件存在
        response.setContentType("application/force-download;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(fileName + fileType,"UTF-8"));
        byte[] buffer = new byte[1024];
        //文件输入流
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        // 文件输出流
        OutputStream os = null;
        try {

            os = response.getOutputStream();
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(bis);
            int i = fis.read(buffer);
            while (i != -1) {
                os.write(buffer);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            System.out.println("异常");
        } finally {
            bis.close();
            fis.close();

        }
        return BaseResult.ok();
    }
}
