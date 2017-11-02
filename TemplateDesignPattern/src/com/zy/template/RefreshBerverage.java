package com.zy.template;

/**
 * 模板方法模式的实现要素: 
 * 准备一个抽象类,将部分逻辑以具体方法的形式实现,
 * 然后声明一些抽象方法交由子类实现剩余逻辑,
 * 用钩子方法给予子类更大的灵活性.
 * 最后将方法汇总构成一个不可改变的模板方法
 */
/**
模板方法的使用场景：
（1）算法或操作遵循相似的逻辑。
（2）重构时（把相同的代码抽取到父类中）
（3）重要的复杂的算法，核心算法设计为模板算法。
 */
/**
模板方法模式的
优点：
（1）封装性好
（2）复用性好
（3）屏蔽细节
（4）便于维护
缺点：
	继承：由于java中的单继承不能再继承其他类
 */

/**
 * 知识点:
 * 	抽象方法
 * 
 * protected abstract void brew();
 * 不知道具体实现: 抽象方法abstract, 不需要实现
 * 需要子类中可见: protected
 * abstract方法 会在子类中 自动生成Override方法
 */
/**
 * 抽象基类abstract class, 为所有子类提供一个算法框架
 * 
 * 提神饮料
 * 
 * @author Zhou
 *
 */
public abstract class RefreshBerverage {

	/**
	 * 模板方法模式
	 * 
	 * 制备饮料的模板方法 
	 * 封装了所有子类共同遵循的算法框架
	 * 
	 */
	// final: 禁止子类 在父类(本类)方法中 进行复写
	public final void prepareBeverageTemplate() {

		// 基本方法: 1.将水煮沸
		boilWater();

		// 抽象方法: 2.泡制饮料
		brew();

		// 基本方法: 3.将饮料倒入杯中
		pourInCup();

		// 判断客户 是否 想加入调味料
		if (isCustomerWantsCondiments()) {
			// 抽象方法: 4.加入调味料
			addCondiments();
		}
	}

	/**
	 * Hook, 钩子函数, 提供一个默认或空的实现
	 * 
	 * 具体的子类 可以 自行决定 是否挂钩 及 如何挂钩
	 * 
	 * 子类可 实现/不实现 该方法
	 * 
	 * 询问用户是否加入调料
	 * @return
	 */
	protected boolean isCustomerWantsCondiments() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 抽象方法 
	 * 不知道具体实现: 抽象方法abstract, 
	 * 不需要实现 需要子类中可见: protected
	 * 
	 * 4.加入调味料
	 */
	protected abstract void addCondiments();

	/**
	 * 基本方法 3.将饮料倒入杯中
	 */
	private void pourInCup() {
		// TODO Auto-generated method stub

		System.out.println("3.将饮料倒入杯中");
	}

	/**
	 * 抽象方法 
	 * 不知道具体实现: 抽象方法abstract, 
	 * 不需要实现 需要子类中可见: protected
	 * 
	 * 2.泡制饮料
	 */
	protected abstract void brew();

	/**
	 * 基本方法 1.将水煮沸
	 */
	private void boilWater() {
		// TODO Auto-generated method stub

		System.out.println("1.将水煮沸");
	}

}
