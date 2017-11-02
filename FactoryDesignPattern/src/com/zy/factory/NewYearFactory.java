package com.zy.factory;

import com.zy.factory.Basic.Boy;
import com.zy.factory.Basic.Girl;
import com.zy.factory.Basic.NewYearBoy;
import com.zy.factory.Basic.NewYearGirl;

/**
 * 新年系列工厂
 * @author Zhou
 *
 */
public class NewYearFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		// TODO Auto-generated method stub
		return new NewYearBoy();
	}

	@Override
	public Girl getGirl() {
		// TODO Auto-generated method stub
		return new NewYearGirl();
	}

}
