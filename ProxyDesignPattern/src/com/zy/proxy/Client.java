package com.zy.proxy;

/**
 * 静态代理 : 继承 | 聚合
 * 
 * 客户端
 * 
 * @author Zhou
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * 静态代理: 聚合更适合
		 */
		// 继承的方式实现代理
		// inherit();

		// 聚合的方法实现代理
		// polymerize();

		// 聚合
		/**
		 * 1. 创建接口类
		 * 2. 创建Car类实现接口类
		 * 3. 创建类CarLogProxy|CarTimeProxy实现接口类Moveable, 聚合Moveable类, 在Moveable类的基础上 添加业务逻辑
		 * 4. 调用
		 */
		timeLogDrive();
//		logTimeDrive();
	}
	
	//  聚合: 代理间相互传递
	public static void timeLogDrive() {
		
		Car car = new Car();
		// 日志代理
		CarLogProxy carLogProxy = new CarLogProxy(car);
		// 时间代理
		CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);

		carTimeProxy.move();
		/**
		 * 先打印时间time, 再打印日志log
			start time
			start log
			driving
			end log
			log 198 毫秒
			end time
			time 198 毫秒
		 */
	}
	
	//  聚合: 代理间相互传递
	public static void logTimeDrive() {
		
		Car car = new Car();
		// 时间代理
		CarTimeProxy carTimeProxy = new CarTimeProxy(car);
		// 日志代理
		CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
		carLogProxy.move();
		/**
		 * 先打印日志log, 再打印时间time
			start log
			start time
			driving
			end time
			time 376 毫秒
			end log
			log 376 毫秒
		 */
	}

	// 聚合的方法实现代理
	public static void polymerize() {

		/**
		 * 聚合的方法实现代理
		 * 1. 创建接口类
		 * 2. 创建Car类实现接口类
		 * 3. 创建一个类Car3ExtendsMoveable实现接口类Moveable, 聚合Car类, 在Car类的基础上 添加业务逻辑
		 * 聚合: 一个类中 调用 另一个类对象
		 * 4. 调用
		 */
		Car car = new Car();

		Moveable car3 = new Car3ExtendsMoveable(car);
		car3.move();
	}

	// 继承的方式实现代理
	public static void inherit() {
		
		/**
		 * 继承的方式实现代理
		 * 1. 创建基类
		 * 2. 创建子类, 在基类的基础上 加 业务逻辑
		 * 3. 调用
		 */
		Car2 car = new Car2();
		car.move();
	}

}
