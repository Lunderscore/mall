package com.ou.mall.util;

import java.io.File;
import java.io.IOException;

import com.ou.mall.bean.UploadedImageFile;

public class ImageUtil {

	public static String transfer(UploadedImageFile image, String dir, String id) throws IllegalStateException, IOException {
		String originalFilename = image.getImage().getOriginalFilename();
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

		// 后缀名判断
		String[] allowSuffix = { ".jpg", ".png", ".gif", ".jpeg", ".bmp" };
		for (int i = 0; i < allowSuffix.length; i++) {
			if (suffix.equals(allowSuffix[i])) {
				break;
			} else if (i == allowSuffix.length - 1) {
				return null;
			}
		}
		String newImageName = id + suffix;
		File newFile = new File(dir, newImageName);
		newFile.getParentFile().mkdirs();
		image.getImage().transferTo(newFile);
		
		return newImageName;
	}
}
