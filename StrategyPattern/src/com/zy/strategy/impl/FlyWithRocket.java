package com.zy.strategy.impl;

import com.zy.strategy.FlyingStragegy;

/**
 * 实现飞行策略接口 : 在太空飞
 * 
 * @author Zhou
 *
 */
public class FlyWithRocket implements FlyingStragegy {

	@Override
	public void performFly() {
		System.out.println("用火箭在太空遨游");
	}

}
