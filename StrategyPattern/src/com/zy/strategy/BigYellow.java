package com.zy.strategy;

import com.zy.strategy.impl.FlyNoWay;

public class BigYellow extends Duck {

	public BigYellow() {
		super();

		// 提供了一个 FlyNoWay实现了FlyingStragegy飞行策略接口
		super.setFlyingStragegy(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("大黄鸭");
	}
	
	/**
	 * 仿照飞行策略模式, 改进继承override方法
	 */
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		super.quack();
	}

}
