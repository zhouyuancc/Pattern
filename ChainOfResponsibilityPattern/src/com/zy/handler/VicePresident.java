package com.zy.handler;

/**
 * 销售副总裁 : 可以批准50%以内的折扣
 * @author Zhou
 *
 */
public class VicePresident extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		// TODO Auto-generated method stub

		if (discount <= 0.5) {
			System.out.format("%s批准了折扣 : %.2f %n", this.getClass().getName(), discount);
		}
		else {
			successor.processDiscount(discount);
		}
	}

}
