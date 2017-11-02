package com.zy.template;

public class RefreshBerverageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("begin Coffee");
	
		RefreshBerverage b1 = new Coffee();
		b1.prepareBeverageTemplate();
		
		System.out.println("Coffee done");
		
		// \n : 回车
		System.out.println("\n---------------------------------------------");

		System.out.println("begin Tea");
		
		RefreshBerverage b2 = new Tea();
		b2.prepareBeverageTemplate();
		
		System.out.println("Tea done");
		
	}

}
