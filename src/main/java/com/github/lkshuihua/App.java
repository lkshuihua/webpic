package com.github.lkshuihua;

import com.github.echisan.wbp4j.UploadPictureUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length<5){
            JOptionPane.showMessageDialog(null, "参数异常,请完善bat文件!", "温馨提示", JOptionPane.ERROR_MESSAGE);
           // System.out.println("参数异常,请完善bat文件!");
            return;
        }

        if(args.length==5){

            try {
                Image image = ImageUtil.getImageFromClipboard();
                if(image==null){
                    JOptionPane.showMessageDialog(null, "粘贴板没有图像,请复制图像再使用!", "温馨提示", JOptionPane.ERROR_MESSAGE);
                    //System.out.println("粘贴板没有图像,请复制图像再使用!");
                    return;
                }

                int isbuildMark=Integer.parseInt(args[3]);
                BufferedImage bufferedImage =null;
                if(isbuildMark==1){
                    //添加水印
                    bufferedImage = ImageMarkLogoUtil.markImageByText(args[4], image, -45);
                }else{
                    //不加水印
                      bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g = bufferedImage.createGraphics();
                      g.drawImage(image, null, null);
                }
               // BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                //Graphics2D g = bufferedImage.createGraphics();
              //  g.drawImage(image, null, null);






                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", outputStream);
                byte[] bytes = outputStream.toByteArray();
                UploadPictureUtils.uploadPicture(bytes,args[0].trim(),args[1].trim(),Integer.parseInt(args[2]));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(args.length>=6){
            //根据图片路径加水印的
            String srcImgPath=args[0].trim();
            try {
                int isbuildMark=Integer.parseInt(args[4]);//是否建立水印
                int state=0;//复制url到粘贴板格式的控制
                state = Integer.parseInt(args[3]);
                BufferedImage bufferedImage =null;
                if(isbuildMark==1){
                    Image srcImg = ImageIO.read(new File(srcImgPath));
                    bufferedImage = ImageMarkLogoUtil.markImageByText(args[5], srcImg, -45);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    ImageIO.write(bufferedImage, "png", outputStream);
                    byte[] bytes = outputStream.toByteArray();

                    UploadPictureUtils.uploadPicture(bytes,args[1].trim(),args[2].trim(),state);
                }else{
                    UploadPictureUtils.uploadPicture(srcImgPath,args[1].trim(),args[2].trim(),state  );
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
