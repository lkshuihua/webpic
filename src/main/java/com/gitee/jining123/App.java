package com.gitee.jining123;

import com.github.echisan.wbp4j.UploadPictureUtils;
import com.github.echisan.wbp4j.UploadRequest;
import com.github.echisan.wbp4j.UploadRequestBuilder;
import com.github.echisan.wbp4j.UploadResponse;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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
    {
        if(args.length<3){
            JOptionPane.showMessageDialog(null, "参数异常,请完善bat文件!", "温馨提示", JOptionPane.ERROR_MESSAGE);
           // System.out.println("参数异常,请完善bat文件!");
            return;
        }

        if(args.length==3){

            try {
                Image image = ImageUtil.getImageFromClipboard();
                if(image==null){
                    JOptionPane.showMessageDialog(null, "粘贴板没有图像,请复制图像再使用!", "温馨提示", JOptionPane.ERROR_MESSAGE);
                    //System.out.println("粘贴板没有图像,请复制图像再使用!");
                    return;
                }
                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = bufferedImage.createGraphics();
                g.drawImage(image, null, null);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", outputStream);
                byte[] bytes = outputStream.toByteArray();
                UploadPictureUtils.uploadPicture(bytes,args[0].trim(),args[1].trim(),Integer.parseInt(args[2]));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(args.length>=4){
            int state=0;
            state = Integer.parseInt(args[3]);
            UploadPictureUtils.uploadPicture(args[0].trim(),args[1].trim(),args[2].trim(),state);
        }
       // UploadPictureUtils.uploadPicture("C:/Users/jining/AppData/Roaming/Typora/typora-user-images/1555834224773.png");
    }

    public static void main1(String[] args) {
        try {
            System.out.println(args.length);
            for(int i=0;i<args.length;i++){
                System.out.println(args[i]);
            }
            String cacheFile=System.getProperties().getProperty("user.home")+System.getProperties().getProperty("file.separator")+"wbpcookie";
            //System.out.println(cacheFile);
            //System.out.println(cacheFile);
            UploadRequest uploadRequest = UploadRequestBuilder.custom("18079266208", "5080466zz,").setCacheFilename(cacheFile).build();

            //获取粘贴板图片
            Image image = ImageUtil.getImageFromClipboard();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(image, null, null);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            //BASE64Encoder encoder = new BASE64Encoder();
            // String base64Img = encoder.encode(outputStream.toByteArray());
            //System.out.println(base64Img);
            UploadResponse upload = uploadRequest.upload(outputStream.toByteArray());
            System.out.println(upload.getImageInfo().getLarge());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 将字符串复制到剪切板。
     */

        @Test
        public void test100() throws Exception{

            JOptionPane.showMessageDialog(null, "标题【出错啦】", "温馨提示", JOptionPane.ERROR_MESSAGE);

        }
}
