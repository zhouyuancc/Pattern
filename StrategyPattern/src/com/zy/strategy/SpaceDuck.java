package com.zy.strategy;

import com.zy.strategy.impl.FlyWithRocket;

public class SpaceDuck extends Duck {

	public SpaceDuck() {
		super();
		
		// 提供了一个 FlyWithRocket实现了FlyingStragegy飞行策略接口
		super.setFlyingStragegy(new FlyWithRocket());
	}

	@Override
	public void display() {
		System.out.println("太空鸭");
	}

	@Override
	public void quack() {
		System.out.println("我通过无线电与你通信");
	}

}
