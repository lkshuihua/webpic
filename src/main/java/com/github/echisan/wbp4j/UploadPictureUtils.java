package com.github.echisan.wbp4j;

import com.gitee.jining123.dao.ImageInfoDAO;
import com.github.echisan.wbp4j.entity.ImageInfo;
import com.github.echisan.wbp4j.exception.UploadFailedException;
import com.github.echisan.wbp4j.interceptor.UploadInterceptor;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.IOException;

public class UploadPictureUtils {
    private UploadPictureUtils(){}



    public  static void uploadPicture(String fileName){

        try {

            String cacheFile=System.getProperties().getProperty("user.home")+System.getProperties().getProperty("file.separator")+".weibo"+System.getProperties().getProperty("file.separator")+"wbpcookie";
            //System.out.println(cacheFile);
            UploadRequest uploadRequest = UploadRequestBuilder.custom("18079266208", "5080466zz,").setCacheFilename(cacheFile).build();
            File file = new File(fileName);
           // String bas64 = ImageMarkLogoUtil.markImageByText("gittee.com.jining", fileName, "G:\\备份\\Will\\01_JavaSE\\大纲\\day06\\类和对象green4.png", -10);
           // System.out.println(bas64);
            UploadResponse response = uploadRequest.upload(file);
            if(response.getResult()==UploadResponse.ResultStatus.SUCCESS){
                ImageInfo imageInfo = response.getImageInfo();
                ImageInfoDAO.save(imageInfo,file.getName() );
                System.out.println(fileName+"上传成功!!!");
                System.out.println("small:"+imageInfo.getSmall());
                System.out.println("middle:"+imageInfo.getMiddle());
                System.out.println("large:"+imageInfo.getLarge());
                setSysClipboardText("!["+file.getName()+"]("+imageInfo.getLarge()+")");
                System.out.println("markdown地址:"+"!["+file.getName()+"]("+imageInfo.getLarge()+")");


            }else{
                System.out.println("失败");
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
