package com.zy.strategy.impl;

import com.zy.strategy.FlyingStragegy;

/**
 * 实现飞行策略接口 : 不会飞
 * 
 * @author Zhou
 *
 */
public class FlyNoWay implements FlyingStragegy {

	@Override
	public void performFly() {
		System.out.println("不会飞");
	}

}
