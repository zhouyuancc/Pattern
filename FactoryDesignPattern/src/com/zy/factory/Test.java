package com.zy.factory;

import com.zy.factory.Basic.Girl;
import com.zy.factory.Basic.HairInterface;
import com.zy.factory.Basic.LeftHair;
import com.zy.factory.Basic.RightHair;

/**
 * 模拟客户端实现
 * 
 * @author Zhou
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 方法一
		// basic();

		// 方法二
		/**
		 * 工厂模式
		 * 类工厂是用来创建类的，
		 * 1. 首先定义一个接口类，
		 * 2. 让具体类实现接口，
		 * 3. 类工厂根据用户的需求去创建具体类。
		 * 如果要自己添加具体类，只需要实现接口，
		 * 通过工厂内部的反射机制（Class.forName(”具体类”)），
		 * 就可以创建新定义的实例对象，
		 * 可见通过工厂把类结构层次透明清晰，同时也使得创建一个新类变得简单。
		 */
		/**
		 * 工厂模式：果然是要用到反射机制：根据类名来创建对象
		    步骤：
		    1.通过类名先获取该类的Class对象
		    2.通过Class对象的newInstance方法来创建目标类的对象
		 */
		// 如果要自己添加具体类，只需要实现接口
//		factory();
		
		//人物工厂
		/**
		 * 抽象工厂模式
		 * 抽象工厂类就是有一个工厂类接口，
		 * 有多个具体的工厂类继承这个工厂类接口，
		 * 获取工厂类需要制定具体调用哪一个工厂类实例，
		 * 然后调用这个工厂类中的方法获取指定的对象。
		 */
		/**
			1.创建一个boy类和girl类的接口，然后针对boy类和girl都有两个具体的实现类，分别是新年系列和圣诞系列的。
			2.接口PersonFactory类提供了两个方法，分别是getBoy()和getGirl()
			3.创建圣诞系列和新年系列工厂实现了PersonFactory类，new出实例对象
		*/
		PersonFactory factory = new MerryXmasFactory();
		Girl girl = factory.getGirl();
		girl.drawGirl();
	}

	// 方法二
	public static void factory() throws Exception {
		HairFactory factory = new HairFactory();
		// HairInterface left = factory.getHair("left");
		// if (left != null) {
		// left.draw();
		// }

		// Class全路径
		// HairInterface left = factory.getHairByClass("com.zy.factory.Basic.LeftHair");
		// left.draw();
		
		// 从配置文件中获取路径, 生成工厂
		String key = "in";
		HairInterface hair = factory.getHairByClassKey(key);
		hair.draw();
	}

	// 方法一
	public static void basic() {
		HairInterface left = new LeftHair();
		left.draw();

		HairInterface right = new RightHair();
		right.draw();
	}

}
