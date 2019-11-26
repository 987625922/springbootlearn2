package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/*
 * springboot不加载格外的resources资源目录下的文件夹，需要格外映射
 * 文件上传测试
 * */
@Controller
//获取配置文件，使用@Value把值直接映射到变量中
@PropertySource({"classpath:resource.properties"})
public class FileController {

    //templates文件夹下的html不加载，需要特殊映射
    //locallhost:8080/api/v1/gopage
    @RequestMapping(value = "/api/v1/gopage")
    public Object index() {
        System.out.println("热加载");
        return "tp";
    }

    //todo 把配置文件中的值映射到String中
    @Value("${web.file.path}")
    private String filePath;

    /*
     * 文件上传接口
     * */
    @RequestMapping("upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("用户名：" + name);
        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);
        System.out.println("配置文件注入的文件路径为" + filePath);
        //获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        //文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return new JsonData(1, fileName, "成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, fileName, "失败");
    }


    @RequestMapping(value = "/download", produces = MediaType.ALL_VALUE)
    public String downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename = "elasticsearch-5.6.8.tar.gz";
        String filePath = "D:\\JAVA\\springbootlearn2\\file";
        File file = new File(filePath + "/" + filename);
        if (file.exists()) { //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(filename, "UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
