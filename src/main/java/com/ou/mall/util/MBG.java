package com.ou.mall.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MBG {
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		// Class.getResource("")    返回的是当前Class这个类所在包开始的为置
		// Class.getResource("/") 返回的是classpath的位置
		// getClassLoader().getResource("")  返回的是classpath的位置
		// getClassLoader().getResource("/")  错误的!!
		File configFile = new File(MBG.class.getResource("/mbg/mbg.xml").getFile());

		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("DONE!!!!");
	}

}