package com.zy.adpter;

/**
 * 采用继承方式的插座适配器
 * 
 * @author Zhou
 *
 */
public class GBTwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {

	@Override
	public void powerWithThree() {// 实现三相接口ThreePlugIf的powerWithThree方法
		System.out.println("采用继承方式的插座适配器");

		// 实现二相类GBTwoPlug的powerWithTwo方法
		this.powerWithTwo();// 使用二相电流供电
	}
}
