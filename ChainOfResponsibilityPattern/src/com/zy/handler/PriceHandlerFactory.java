package com.zy.handler;

public class PriceHandlerFactory {

	/**
	 * 责任链的工厂函数
	 * 
	 * 创建PriceHandler的工厂方法
	 * 
	 * @return
	 */
	public static PriceHandler createPriceHandler() {
	
		PriceHandler sales = new Sales();
		PriceHandler salesLeader = new SalesLeader();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler vicePresident = new VicePresident();
		PriceHandler ceo = new CEO();
	
		// 责任链一层一层往上抛
		// sales销售 的直接后继是 manager销售经理
		sales.setSuccessor(salesLeader);
		salesLeader.setSuccessor(manager);
		// manager销售经理 的直接后继是director销售总监
		manager.setSuccessor(director);
		// director销售总监 的直接后继是vicePresident销售副总裁
		director.setSuccessor(vicePresident);
		// vicePresident销售副总裁 的直接后继是ceo
		vicePresident.setSuccessor(ceo);
	
		// 接待的人是sales
		return sales;
	}

}
