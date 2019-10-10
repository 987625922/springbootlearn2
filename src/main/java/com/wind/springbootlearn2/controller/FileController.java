package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*
 * springboot不加载格外的resources资源目录下的文件夹，需要格外映射
 * 文件上传测试
 * */
@Controller
public class FileController {

    //templates文件夹下的html不加载，需要特殊映射
    //locallhost:8080/api/v1/gopage
    @RequestMapping(value = "/api/v1/gopage")
    public Object index() {
        System.out.println("热加载");
        return "tp";
    }

    private static final String filePath = "C:\\Users\\98762\\Desktop\\";

    @RequestMapping("upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("用户名：" + name);
        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

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
}
