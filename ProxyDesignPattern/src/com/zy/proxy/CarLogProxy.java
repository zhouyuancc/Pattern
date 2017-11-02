package com.zy.proxy;

/**
 * 知识点: 
 * 聚合: 一个类中 调用 另一个类对象
 * @author Zhou
 *
 */
public class CarLogProxy implements Moveable {

	// 聚合: 一个类中 调用 另一个类对象
	private Moveable m;
	
	public CarLogProxy(Moveable m) {
		// TODO Auto-generated constructor stub
		
		super();
		this.m = m;
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();
		System.out.println("start log");
		
		// 执行Moveable m的move();
		m.move();
		
		long endTime = System.currentTimeMillis();
		System.out.println("end log");
		System.out.println("log " + (endTime - startTime) + " 毫秒");
	}
}
