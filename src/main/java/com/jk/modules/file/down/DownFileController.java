package com.jk.modules.file.down;

import com.jk.modules.sys.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 2018/1/20 0020.
 */
@RestController
@RequestMapping("/down/file")
public class DownFileController extends AbstractController {

    /**
     * 文件下载：单个get方式足矣
     */
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    @ResponseBody
    public void  One(HttpServletResponse response){
//        下载的文件路径
        String path = "D:\\Java\\SpringBootFream\\SpringBoot\\src\\main\\resources\\static\\upload\\file\\pic\\151641235250311.jpg";
//        下载的文件名称
        String downName = "down.jpg";
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + downName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(path)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("问价下载成功！");
    }


    /**
     * 文件下载：多个get方式足矣
     * 思路：页面勾选需要下载的文件，将数据传到后台，后台根据数据获取对应文件的路径，将文件达成压缩包，下载下来
     */
    @RequestMapping(value = "/more", method = RequestMethod.GET)
    @ResponseBody
    public void  More(HttpServletResponse response,String value)throws Exception{
        //        下载的文件路径   这里只是一个例子
        String path1 = "D:\\Java\\SpringBootFream\\SpringBoot\\src\\main\\resources\\static\\upload\\file\\pic\\151641235250311.jpg";
        String path2 = "D:\\Java\\SpringBootFream\\SpringBoot\\src\\main\\resources\\static\\upload\\file\\pic\\151641536426411.jpg";
        String path3 = "D:\\Java\\SpringBootFream\\SpringBoot\\src\\main\\resources\\static\\upload\\els\\1516412490819layer-v2.1.zip";
        String path4 = "D:\\Java\\SpringBootFream\\SpringBoot\\src\\main\\resources\\static\\upload\\els\\151641249082011.jpg";


        //文件名称  可以设置成自己的源文件名称
        String[] names={"one.jpg","two.jpg","three.zip","four.jpg"};
        //生成的压缩包名称
        String zipName = "newZip.zip";
        //四个文件流
        FileInputStream input1 = new FileInputStream(new File(path1));
        FileInputStream input2 = new FileInputStream(new File(path2));
        FileInputStream input3 = new FileInputStream(new File(path3));
        FileInputStream input4 = new FileInputStream(new File(path4));
        FileInputStream[] inputs={input1,input2,input3,input4};
        //ZIP打包图片
        File zipFile = new File("../" + "SpringBoot" + "/src/main/resources/static/upload/els/test.zip");
        byte[] buf = new byte[1024];
        int len;
        ZipOutputStream zout=new ZipOutputStream(new FileOutputStream(zipFile));
        for (int i = 0; i < inputs.length; i++) {
            FileInputStream in =inputs[i];
            zout.putNextEntry(new ZipEntry(names[i]));
            while ((len = in.read(buf)) > 0) {
                zout.write(buf, 0, len);
            }
            zout.closeEntry();
            in.close();
        }
        zout.close();


        //下载图片
        FileInputStream zipInput =new FileInputStream(zipFile);
        OutputStream out = response.getOutputStream();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename="+zipName);
        while ((len=zipInput.read(buf))!= -1){
            out.write(buf,0,len);
        }
        zipInput.close();
        out.flush();
        out.close();
        //删除压缩包
        zipFile.delete();





    }










}
