package com.github.echisan.wbp4j;

import com.github.echisan.wbp4j.entity.ImageInfo;
import com.github.echisan.wbp4j.exception.UploadFailedException;
import com.github.echisan.wbp4j.interceptor.UploadInterceptor;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UploadPictureUtils {
    private UploadPictureUtils(){}



    public  static void uploadPicture(String fileName,String username,String password,int state){

        try {



            String cacheFile=System.getProperties().getProperty("user.home")+System.getProperties().getProperty("file.separator")+"wbpcookie";
            //System.out.println(cacheFile);
            //System.out.println(cacheFile);
            UploadRequest uploadRequest = UploadRequestBuilder.custom(username, password).setCacheFilename(cacheFile).build();
            File file = new File(fileName);
           // String bas64 = ImageMarkLogoUtil.markImageByText("gittee.com.jining", fileName, "G:\\备份\\Will\\01_JavaSE\\大纲\\day06\\类和对象green4.png", -10);
           // System.out.println(bas64);
            UploadResponse response = uploadRequest.upload(file);
            if(response.getResult()==UploadResponse.ResultStatus.SUCCESS){
                ImageInfo imageInfo = response.getImageInfo();
                //ImageInfoDAO.save(imageInfo,file.getName() );
                System.out.println(fileName+"上传成功!!!");
                System.out.println("small:"+imageInfo.getSmall());
                System.out.println("middle:"+imageInfo.getMiddle());
                System.out.println("large:"+imageInfo.getLarge());
                String text="!["+file.getName()+"]("+imageInfo.getLarge()+")";
                if(state==0){
                     text="!["+file.getName()+"]("+imageInfo.getLarge()+")";
                }else if(state==1){
                     text=imageInfo.getLarge();
                }
                setSysClipboardText(text);
                System.out.println("markdown地址:"+"!["+file.getName()+"]("+imageInfo.getLarge()+")");
                JOptionPane.showMessageDialog(null, "粘贴板没有图像,请复制图像再使用!", "温馨提示", JOptionPane.ERROR_MESSAGE);

            }else{
                System.out.println("上传图片失败");
            }
            //System.out.println(response.getImageInfo());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UploadFailedException e) {
            e.printStackTrace();
        }
         catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  static void uploadPicture(byte[] bytes,String username,String password,int state){

        try {



            String cacheFile=System.getProperties().getProperty("user.home")+System.getProperties().getProperty("file.separator")+"wbpcookie";
            //System.out.println(cacheFile);
            //System.out.println(cacheFile);
            UploadRequest uploadRequest = UploadRequestBuilder.custom(username, password).setCacheFilename(cacheFile).build();
            //File file = new File(fileName);
           // String bas64 = ImageMarkLogoUtil.markImageByText("gittee.com.jining", fileName, "G:\\备份\\Will\\01_JavaSE\\大纲\\day06\\类和对象green4.png", -10);
           // System.out.println(bas64);
            UploadResponse response = uploadRequest.upload(bytes);
            if(response.getResult()==UploadResponse.ResultStatus.SUCCESS){
                ImageInfo imageInfo = response.getImageInfo();
                //ImageInfoDAO.save(imageInfo,file.getName() );
               // System.out.println(fileName+"上传成功!!!");
                System.out.println("small:"+imageInfo.getSmall());
                System.out.println("middle:"+imageInfo.getMiddle());
                System.out.println("large:"+imageInfo.getLarge());
                String text="![]("+imageInfo.getLarge()+")";
                if(state==0){
                     text="![]("+imageInfo.getLarge()+")";
                }else if(state==1){
                     text=imageInfo.getLarge();
                }
                setSysClipboardText(text);
                System.out.println("markdown地址:"+"![]("+imageInfo.getLarge()+")");


            }else{
                System.out.println("上传图片失败");
            }
            //System.out.println(response.getImageInfo());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UploadFailedException e) {
            e.printStackTrace();
        }
         catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }

}
