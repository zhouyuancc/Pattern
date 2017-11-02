package com.zy.factory;

import com.zy.factory.Basic.HairInterface;
import com.zy.factory.Basic.LeftHair;
import com.zy.factory.Basic.RightHair;

/**
 * 发型工厂
 * 
 * @author Zhou
 *
 */
public class HairFactory {

	/**
	 * 方法一: 根据类型来创建对象
	 * 
	 * @param key
	 * @return
	 */
	public HairInterface getHair(String key) {
		if ("left".equals(key)) {
			return new LeftHair();
		} else if ("right".equals(key)) {
			return new RightHair();
		}
		return null;
	}
	
	/**
	 * 反射机制: 
	 * 创建类: Class.forName("").newInstance()|通过字符串创建类
	 * 获取类: Class.forName("") | .class | .getClass()
	 * 
	 * 方法二: 根据类的名称生成工厂
	 * @param key
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public HairInterface getHairByClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		HairInterface hairInterface = (HairInterface) Class.forName(className).newInstance();
		return hairInterface;
	}
	
	/**
	 * 反射机制: 
	 * 创建类: Class.forName("").newInstance()|通过字符串创建类
	 * 获取类: Class.forName("") | .class | .getClass()
	 * 
	 * 方法三: 根据配置文件的key获取类的名称value生成工厂
	 * @param key
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws Exception 
	 */
	public HairInterface getHairByClassKey(String key) throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception
	{
		PropertiesReader properties = new PropertiesReader("/Users/Zhou/eclipse-workspace/FactoryDesignPattern/src/type.properties");
		String locator = properties.getPro(key);
		
		HairInterface hairInterface = (HairInterface) Class.forName(locator).newInstance();
		return hairInterface;
	}


}
