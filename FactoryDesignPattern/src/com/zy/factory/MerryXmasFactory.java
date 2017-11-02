package com.zy.factory;

import com.zy.factory.Basic.Boy;
import com.zy.factory.Basic.Girl;
import com.zy.factory.Basic.MerryXmasBoy;
import com.zy.factory.Basic.MerryXmasGirl;

/**
 * 圣诞系列工厂
 * @author Zhou
 *
 */
public class MerryXmasFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		// TODO Auto-generated method stub
		return new MerryXmasBoy();
	}

	@Override
	public Girl getGirl() {
		// TODO Auto-generated method stub
		return new MerryXmasGirl();
	}

}
