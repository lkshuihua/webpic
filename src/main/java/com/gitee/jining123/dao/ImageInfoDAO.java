package com.gitee.jining123.dao;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.github.echisan.wbp4j.entity.ImageInfo;

public class ImageInfoDAO {
    static {

        AVOSCloud.initialize("pgKj9LSuJaSbEqnzVsqkpfOh-gzGzoHsz", "0taSNYxRKq1BnsQaVfbboNcn", "V3ufqC5iAgpovXiko7hnXSwg");

        AVOSCloud.setDebugLogEnabled(false);
    }

    public static AVObject save(ImageInfo picture,String fileName) throws Exception {
        AVObject imageInfo = new AVObject("imageInfo");// 构建对象
        imageInfo.put("pid", picture.getPid());// 设置pid
        imageInfo.put("height", picture.getHeight());// 设置优先级
        imageInfo.put("width", picture.getWidth());// 设置优先级
        imageInfo.put("size", picture.getSize());// 设置优先级
        imageInfo.put("small", picture.getSmall());// 设置优先级
        imageInfo.put("middle", picture.getMiddle());// 设置优先级
        imageInfo.put("large", picture.getLarge());
        imageInfo.put("fileName", fileName);
        imageInfo.save();// 保存到服务端
        return imageInfo;
    }

}
