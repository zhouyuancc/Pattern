package com.zy.handler;

import java.util.Random;

/**
 * 客户, 申请折扣
 * 
 * @author Zhou
 *
 */
public class Customer {

	private PriceHandler priceHandler;

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	/**
	 * 请求折扣
	 * @param discount
	 */
	public void requestDiscount(float discount) {
		priceHandler.processDiscount(discount);
	}

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

		Random random = new Random();

		for (int i = 0; i < 100; i++) {
			// random.nextFloat() : 随机生成浮点数[0.0，1.0)
			float discount = random.nextFloat();
			System.out.println(i + " : " + discount);

			customer.requestDiscount(discount);
		}
		/**
			0 : 0.5682995
			com.zy.handler.CEO拒绝批准折扣 : 0.57 
			1 : 0.06936175
			com.zy.handler.Manager批准了折扣 : 0.07 
			2 : 0.66518146
			com.zy.handler.CEO拒绝批准折扣 : 0.67 
			3 : 0.30335224
			com.zy.handler.Director批准了折扣 : 0.30 
			4 : 0.90581965
			com.zy.handler.CEO拒绝批准折扣 : 0.91 
		 */
	}

}
