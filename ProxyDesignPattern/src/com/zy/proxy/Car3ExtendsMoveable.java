package com.zy.proxy;

/**
 * 知识点: 
 * 聚合: 一个类中 调用 另一个类对象
 * @author Zhou
 *
 */
public class Car3ExtendsMoveable implements Moveable {

	// 聚合: 一个类中 调用 另一个类对象
	private Car car;
	
	public Car3ExtendsMoveable(Car car) {
		// TODO Auto-generated constructor stub
		
		super();
		this.car = car;
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();
		System.out.println("start drive");
		
		car.move();
		
		long endTime = System.currentTimeMillis();
		System.out.println("end drive");
		System.out.println("drive " + (endTime - startTime) + " 毫秒");
	}

}
