package com.xxx.mall.util;

import com.xxx.mall.bean.UploadedImageFile;

import java.io.File;
import java.io.IOException;

public class ImageUtil {

    /*
     * 返回  id.后缀名
     */
    public static String transfer(UploadedImageFile image, String dir, String fileName) throws IllegalStateException, IOException {
        String originalFilename = image.getImage().getOriginalFilename();
        if (image.getImage().getOriginalFilename().equals("")) {
            return null;
        } else if (originalFilename.lastIndexOf(".") == -1) {
            return null;
        }

        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 后缀名判断
        String[] allowSuffix = {".jpg", ".png", ".gif", ".jpeg", ".bmp"};
        for (int i = 0; i < allowSuffix.length; i++) {
            // 忽略大小写
            if (suffix.toLowerCase().equals(allowSuffix[i])) {
                break;
            } else if (i == allowSuffix.length - 1) {
                return null;
            }
        }
        String newImageName = fileName + suffix;
        File newFile = new File(dir, newImageName);
        newFile.getParentFile().mkdirs();
        image.getImage().transferTo(newFile);

        return newImageName;
    }
}
