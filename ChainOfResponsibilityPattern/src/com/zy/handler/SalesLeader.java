package com.zy.handler;

/**
 * 销售小组长 : 可以批准15%以内的折扣
 * @author Zhou
 *
 */
public class SalesLeader extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		// TODO Auto-generated method stub
		
		if (discount <= 0.15) {
			System.out.format("%s批准了折扣 : %.2f %n", this.getClass().getName(), discount);
		}
		else {
			successor.processDiscount(discount);
		}
	}

}
