package com.zy.handler;

/**
 * 销售 : 可以批准5%以内的折扣
 * 
 * @author Zhou
 *
 */
public class Sales extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		// TODO Auto-generated method stub

		if (discount <= 0.05) {
			System.out.format("%s批准了折扣 : %.2f %n", this.getClass().getName(), discount);
		}
		else {
			// 责任链一层一层往上抛
			successor.processDiscount(discount);
		}
	}

}
