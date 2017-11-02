package com.zy.adpter;

/**
 * 二相转三相的插座适配器
 * 
 * @author Zhou
 *
 */
public class GBTwoPlugAdapter implements ThreePlugIf {

	private GBTwoPlug gbTwoPlug;

	// 组合方式适配器的构造方法传入二相插口类
	public GBTwoPlugAdapter(GBTwoPlug gbTwoPlug) {
		
		this.gbTwoPlug = gbTwoPlug;
	}

	@Override
	public void powerWithThree() {// ThreePlugIf接口的方法
		
		System.out.println("通过转换 - 二相转三相的插座适配器");
		gbTwoPlug.powerWithTwo();// 使用二相电流供电
	}

}
