package com.gitee.jining123;

import com.github.echisan.wbp4j.UploadPictureUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    String path = System.getProperty("java.class.path");
         int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
         int lastIndex = path.lastIndexOf(File.separator) + 1;
         path = path.substring(firstIndex, lastIndex);

        //System.out.println(resource);
        Properties p = new Properties();
        try {
           // p.load(in);
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(args.length==0){
            System.out.println("请输入图片路径!");
            return;
        }

       UploadPictureUtils.uploadPicture(args[0].trim());
       // UploadPictureUtils.uploadPicture("C:/Users/jining/AppData/Roaming/Typora/typora-user-images/1555834224773.png");
    }

    /**
     * 将字符串复制到剪切板。
     */


}
