package com.zy.strategy;

/**
 * 父类 : 所有鸭子都继承此类
 * 
 * 抽象了鸭子的行为 : 显示 和 鸣叫
 * 
 * @author Zhou
 *
 */
public abstract class Duck {

	/**
	 * 方法一 : 继承方法 override
	 * 
	 * 鸭子发出叫声
	 * 通用行为, 由父类实现
	 */
	public void quack() {
		System.out.println("嘎嘎嘎");
	}
	
	/**
	 * 方法二 : 抽象方法
	 * 
	 * 显示鸭子的外观
	 * 鸭子外观各不相同, 声明为abstract, 由子类实现
	 */
	public abstract void display();
	
	/**
	 * 方法三 : 组合一个策略对象, 将飞行行为代理给该对象的实现
	 * 多用组合, 少用继承
	 * 
	 * 策略模式的实现
	 * 1. 通过分离变化得出策略接口Strategy
	 * 		创建FlyStrategy接口
	 * 2. 创建FlyStrategy接口的实现类FlyWithWing/FlyNoWay/FlyWithRocket
	 * 3. 客户程序中有一个Strategy
	 * 		在鸭子父类中, set飞行策略 and 执行飞行行为
	 * 4. 在客户程序中选择/组装正确的FlyStrategy接口实现类
	 * 		在鸭子子类的构造方法中, set父类的接口实现类super.setFlyingStragegy(new FlyWithWing());
	 * 
	 * 优点
	 * 1. 使用了组合, 使架构更加灵活
	 * 2. 富有弹性, 可以较好的应对变化(开闭原则)
	 * 3. 更好的代码复用性(相对于继承)
	 * 4. 消除大量的条件语句, 更好的可读性, 面向对象的特性, 易于维护
	 * 
	 * 缺点
	 * 1. 客户代码需要了解每个策略实现的细节
	 * 2. 增加了对象的数量
	 * 
	 * 使用场景
	 * 1. 许多相关的类仅仅是行为差异
	 * 2. 运行时选取不同的算法变体(不同子类鸭子, 每只选一个飞行方法)
	 * 3. 条件语句if else很多时, 通过条件语句在多个分支中选择一
	 * 
	 * 飞行策略接口
	 */
	private FlyingStragegy flyingStragegy;

	public void setFlyingStragegy(FlyingStragegy flyingStragegy) {
		this.flyingStragegy = flyingStragegy;
	}
	/**
	 * 由飞行策略接口 执行 飞行方法
	 */
	public void fly() {
		flyingStragegy.performFly();
	}
	
}
