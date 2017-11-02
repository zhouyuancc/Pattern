package com.zy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.zy.proxy.Car;
import com.zy.proxy.Moveable;

/**
 * 代理模式-动态代理 : JDK的动态代理模式
	这种方式叫做AOP面向切面编程 : 
	在不改变原有类及方法的基础上，增加一些额外的业务逻辑
	
	例如：
		要调用某个jar包中某个类的方法，但是不能改变源码.
		我们可以采用JDK的动态代理模式，
		在方法的前后添加业务逻辑，
		如记录日志，权限控制等
 */
/**
 * 动态代理
 * 
 * @author Zhou
 *
 */
public class TestJDKProxy {

	public static void main(String[] args) throws NoSuchMethodException, Exception {
		// TODO Auto-generated method stub

//		jdkProxy();
		
		/**
		 * 1. 创建接口类Moveable, 创建实现接口类的类Car
		 * 2. 自定义MyInvocationHandler继承InvocationHandler
		 * 3. 创建事务处理器MyTimeHandler实现MyInvocationHandler(自定义) , 聚合Object(Car)类
		 * 4. 自定义MyProxy.java代理
		 * 5. 调用
		 */
		/**
		 * 自定义模拟JDK动态代理
		 * 
		 * 动态代理实现思路
		 * 实现功能 : 通过Proxy的newProxyInstance返回代理对象
		 * 
		 * MyProxy.java 生成 $Proxy0.java
		 * 1. 声明一段源码(动态生成代理)
		 * 用String写一个java类, 类的内容为字符串形式, 生成一个.java文件
		 * 
		 * 2. 编译源码(JDK Compliler API), 产生新的类(代理类)
		 * 产生.class文件
		 * 
		 * 3. 将这个类load到内存中,产生一个新的对象(代理对象) 
		 * 4. return 代理对象
		 */
		Car car = new Car();
		MyInvocationHandler handler = new MyTimeHandler(car);
		
		Moveable moveable = (Moveable)MyProxy.newProxyInstance(Moveable.class, handler);
		moveable.move();
		/**
		    /Users/Zhou/eclipse-workspace/ProxyDesignPattern/src/com/zy/jdkProxy/$Proxy0.java
			com.zy.jdkProxy.$Proxy0
			MyTimeHandler start
			driving
			during 432 time
		 */
	}
	
	public static void jdkProxy() {

		/**
		 * 1. 创建接口类Moveable, 创建实现接口类的类Car
		 * 2. 创建事务处理器TimeHandler实现InvocationHandler(系统), 聚合Object(Car)类
		 * 3. 调用
		 */
		Car car = new Car();
		InvocationHandler hTime = new TimeHandler(car);

		Class<?> class1 = car.getClass();
		
		/**
		 * loader : 类加载器
		 * interfaces : 实现接口
		 * h : InvocationHandler 事件处理器
		 * 
		 * 动态代理实现思路
		 * 实现功能 : 通过Proxy的newProxyInstance返回代理对象
		 * 
		 * 1. 声明一段源码(动态生成代理)
		 * 2. 编译源码(JDK Compliler API), 产生新的类(代理类)
		 * 3. 将这个类load到内存中,产生一个新的对象(代理对象) 
		 * 4. return 代理对象
		 */
		Moveable hTimeCar = (Moveable) Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), hTime);

//		hTimeCar.move();
//		/**
//			start TimeHandler invoke
//			driving
//			end TimeHandler invoke
//			TimeHandler invoke 658 毫秒
//	     */
		
		// 添加日志事务, 日志与时间同时调用
		InvocationHandler hLog = new LogHandler(hTimeCar);
		
		// 日志与时间同时调用
		Moveable hLogCar = (Moveable) Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), hLog);
		hLogCar.move();
		
		/**
		 * 先打印日志, 再打印时间
		    start LogHandler invoke
			start TimeHandler invoke
			driving
			end TimeHandler invoke
			TimeHandler invoke 482 毫秒
			end LogHandler invoke
			LogHandler invoke 482 毫秒
		 */
		
		// 代理名
		System.out.println("代理类名 : " + hTimeCar.getClass().getName());
		// 代理类名 : com.sun.proxy.$Proxy0
	}

}
