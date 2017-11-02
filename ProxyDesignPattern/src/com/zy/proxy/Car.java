package com.zy.proxy;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		// TODO Auto-generated method stub

		// 实现开车
		try {

			// 1分钟
			// new Random().nextInt(1000) : 0-1000随机数
			Thread.sleep(new Random().nextInt(1000));
			
			System.out.println("driving");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
