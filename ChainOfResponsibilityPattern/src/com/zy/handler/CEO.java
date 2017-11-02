package com.zy.handler;

/**
 * 折扣超出55%, 拒绝申请
 * @author Zhou
 *
 */
public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		// TODO Auto-generated method stub
		if (discount <= 0.55) {
			System.out.format("%s批准了折扣 : %.2f %n", this.getClass().getName(), discount);
		}
		else {
			System.out.format("%s拒绝批准折扣 : %.2f %n", this.getClass().getName(), discount);
		}
	}

}
