package com.zy.factory;

import com.zy.factory.Basic.Boy;
import com.zy.factory.Basic.Girl;

/**
 * 人物工厂的实现接口
 * 
 * @author Zhou
 *
 */
public interface PersonFactory {

	public Boy getBoy();

	public Girl getGirl();
	
}
