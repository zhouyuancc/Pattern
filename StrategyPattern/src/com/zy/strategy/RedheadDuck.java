package com.zy.strategy;

import com.zy.strategy.impl.FlyWithWing;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		super();

		//提供了一个 FlyWithWing实现了FlyingStragegy飞行策略接口
		super.setFlyingStragegy(new FlyWithWing());
	}

	@Override
	public void display() {
		System.out.println("红头鸭");
	}

}
