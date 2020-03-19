package com.soft1851.orm.util;

import java.io.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/17
 * @Version 1.0
 */
public class FileUtil {

    public static byte[] readImage(String path){
        File file = new File(path);
        InputStream in = null;
        byte[] buffer = null;
        try {
            in = new FileInputStream(file);
            buffer = new byte[(int) file.length()];
            System.out.println(buffer.length);
            in.read(buffer);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
