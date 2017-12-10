package com.ou.mall.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ou.mall.bean.UploadedImageFile;

@Controller
public class ImageTest {

	@RequestMapping("image")
	public void test(UploadedImageFile image) throws Exception{
		String name = "1";
        String newImageName = name + ".jpg";
        
        System.out.println(newImageName);
        
        File newFile = new File("d:/img", newImageName);
        newFile.getParentFile().mkdirs();
        image.getImage().transferTo(newFile);
	}
}
