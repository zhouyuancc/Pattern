package com.zy.template;

/**
 * 具体子类, 提供了制备茶的具体实现
 * @author Zhou
 *
 */
public class Tea extends RefreshBerverage {

	@Override
	protected void addCondiments() {
		// TODO Auto-generated method stub
		
		System.out.println("Tea---4.加入柠檬");
	}

	@Override
	protected void brew() {
		// TODO Auto-generated method stub
		
		System.out.println("Tea---2.用热水浸泡茶叶5分钟");
	}
	
	/**
	 * 子类通过 Override覆盖的形式 选择 挂载 钩子函数
	 */
	@Override
	protected boolean isCustomerWantsCondiments() {
		// TODO Auto-generated method stub
		return false;
	}

}
