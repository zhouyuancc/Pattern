package com.zy.template;

/**
 * 具体子类, 提供了制备咖啡的具体实现
 * @author Zhou
 *
 */
public class Coffee extends RefreshBerverage {

	@Override
	protected void addCondiments() {
		// TODO Auto-generated method stub

		System.out.println("Coffee---4.加入调味料");
	}

	@Override
	protected void brew() {
		// TODO Auto-generated method stub

		System.out.println("Coffee---2.泡制饮料");
	}

}
