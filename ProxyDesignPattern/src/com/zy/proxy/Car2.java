package com.zy.proxy;

public class Car2 extends Car {

	@Override
	public void move() {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();
		System.out.println("start drive");
		
		// Car move();
		super.move();
		
		long endTime = System.currentTimeMillis();
		System.out.println("end drive");
		System.out.println("drive " + (endTime - startTime) + " 毫秒");
		
	}
}
