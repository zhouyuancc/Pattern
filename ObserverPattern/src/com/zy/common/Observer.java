package com.zy.common;

/**
 * 接口里的方法, 实现的类必须都重写
 */
/**
 * 监听者/观察者 实现 该接口
 * 
 * 观察者接口: 定义一个更新的接口 给那些 在目标发生改变的时候 被通知的对象
 * @author Zhou
 *
 */
public interface Observer {

	/**
	 * 观察者进行更新的接口
	 * @param subject 传入目标对象, 方便获取相应的目标对象的状态
	 */
	public void update(Subject subject);

}
