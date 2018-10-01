package com.jk.modules.file.upload;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2018/1/19 0019.
 * 内容：文件上传工具类
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
