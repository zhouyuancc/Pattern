package com.zy.factory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件的读取类
 * @author Zhou
 *
 */
public class PropertiesReader {

	private Properties properties;
	private String filePath;

	/**
	 * 构造方法
	 * 
	 * @param properties
	 * @param filePath
	 * @throws IOException
	 */
	public PropertiesReader(String filePath) throws IOException {
		super();
		this.filePath = filePath;
		this.properties = readProperties();// 读取配置文件
	}

	public PropertiesReader() {

	}

	/**
	 * 读取配置文件
	 * 
	 * @return
	 * @throws IOException
	 */
	private Properties readProperties() throws IOException {

		// 实例化
		Properties properties = new Properties();

		try {

			// 读取文件
			InputStream in = new FileInputStream(this.filePath);// "element.properties"
			// 读取文件 放到缓存里
			InputStream inputStream = new BufferedInputStream(in);
			// 加载
			properties.load(inputStream);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回Properties
		return properties;
	}
	
	/**
	 * 写入内容
	 * @param key
	 * @param value
	 */
	public void writePro(String key,String value) {
		
		//实例化
		Properties properties = new Properties();
		
		try {

			//输出流
			FileOutputStream fileOutputStream = new FileOutputStream(this.filePath);
			//set
			properties.setProperty(key, value);
			//存储
			properties.store(fileOutputStream, key);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * id>loginname
	 * Properties配置文件 : load加载/setProperty设置/getProperty获取
	 * 
	 * @throws IOException
	 */
	public String getPro(String key) throws Exception {

		/**
		 * 新建一个properties文件 : New -> file -> element.properties 
		 * loginname=id>loginname
		 * WebElement loginname = driver.findElement(By.id("loginname"));
		 */
		if (this.properties.containsKey(key)) {
			// 直接可以从配置文件根据 key: loginname , 获取 id>loginname
			String loginname = properties.getProperty(key);
			System.out.println(loginname);// 打印结果: id>loginname

			return loginname;
		} else {
			System.out.println(this.filePath + "的key值 "+key+" 不正确");
			return "";
		}

	}
	
}
