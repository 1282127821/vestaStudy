package com.xy.断点续传;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @fileName:下载进度
 * @author:xy
 * @date:2020/4/7
 * @description:
 */
@Controller
public class 下载进度 {


    @RequestMapping("/prog")
    @ResponseBody
    //http://localhost:63342/springboot3/com/xy/断点续传/index.html 注意是63342
    // 所以后面我换了下自己输入网址这样就不是跨域了但是这样我要重新写一个加载窗口
    //跨域导致session不是同一个。
    @CrossOrigin(origins = "*", maxAge = 3600)//idea的html和controller是有跨域问题
    public Progress progress(HttpSession session) {
        Progress progress = (Progress) session.getAttribute("progress");
        if(progress!=null){
            System.out.println(progress);
        }
        return progress;
    }

    @RequestMapping(value="/index")
    public String GoToIndex(HttpServletRequest request, HttpServletResponse response){
        return "index";
    }

    @RequestMapping("/download")
    public static void download(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception {
        File file = new File("G:\\work\\soft\\development\\video.mp4");
        //设置响应头和客户端保存文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
        //用于记录以完成的下载的数据量，单位是byte
        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(file);
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            int fileLength = (int) file.length();
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
                Progress progress = (Progress) session.getAttribute("progress");
                if (progress == null) {
                    Progress progressRecord = new Progress();
                    progressRecord.setTotal(fileLength);
                    session.setAttribute("progress", progressRecord);
                }
                progress = (Progress) session.getAttribute("progress");
                progress.setProgress(progress.getProgress() + b.length);
                //延迟模拟大文件 其实只有8m左右太快了
                TimeUnit.MILLISECONDS.sleep(1);
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e) {
            throw e;
        }
    }

    @Deprecated
    @RequestMapping("/download2")
    public ResponseEntity<byte[]> download(HttpServletRequest request, HttpSession session) throws IOException {
        File file = new File("G:\\work\\soft\\development\\video.mp4");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        Progress progress = (Progress) session.getAttribute("progress");
        if (progress == null) {
            Progress progressRecord = new Progress();
            progressRecord.setTotal((int) file.length());
            session.setAttribute("progress", progressRecord);
        }
        progress = (Progress) session.getAttribute("progress");
        progress.setProgress(progress.getProgress() + body.length);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}
