package com.zy.strategy;

import com.zy.strategy.impl.FlyNoWay;

/**
 * 橡胶鸭
 * 
 * @author Zhou
 *
 */
public class RubberDuck extends Duck {

	public RubberDuck() {
		super();

		// 提供了一个 FlyNoWay实现了FlyingStragegy飞行策略接口
		super.setFlyingStragegy(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("橡胶鸭");
	}

	@Override
	public void quack() {
		// super.quack();
		System.out.println("嘎~嘎~嘎~");
	}

}
