package com.zy.strategy.impl;

import com.zy.strategy.FlyingStragegy;

/**
 * 实现飞行策略接口 : 会飞
 * 
 * @author Zhou
 *
 */
public class FlyWithWing implements FlyingStragegy {

	@Override
	public void performFly() {

		System.out.println("振翅高飞");
	}

}
