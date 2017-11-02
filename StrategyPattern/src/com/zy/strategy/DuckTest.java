package com.zy.strategy;

public class DuckTest {

	public static void main(String[] args) {

		Duck duck = null;
//		duck = new MallardDuck();
		// Command+Alt+向下箭头 : 复制代码到下一行
//		duck = new RedheadDuck();
//		duck = new RubberDuck();
//		duck = new BigYellow();
		duck = new SpaceDuck();
		
		// 执行子类方法 
		duck.display();
		duck.quack();
		duck.fly();
		/**
		    绿脖鸭/红头鸭
			嘎嘎嘎
			振翅高飞
		 */
		/**
		    橡胶鸭
			嘎~嘎~嘎~
			不会飞
		 */
		/**
		    大黄鸭
			嘎嘎嘎
			不会飞
		 */
		/**
		    太空鸭
			我通过无线电与你通信
			用火箭在太空遨游
		 */
	}

}
