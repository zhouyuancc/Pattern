package com.zy.handler;

/**
 * 价格处理人 : 负责处理客户折扣申请
 * 
 * @author Zhou
 *
 */
public abstract class PriceHandler {

	/**
	 * 直接后继, 用于传递请求
	 */
	protected PriceHandler successor;

	// public PriceHandler getSuccessor() {
	// return successor;
	// }

	/**
	 * set方法便于构造责任链
	 * 
	 * @param successor
	 */
	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}

	/**
	 * 处理折扣申请
	 */
	public abstract void processDiscount(float discount);

}
