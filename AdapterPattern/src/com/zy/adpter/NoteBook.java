package com.zy.adpter;

public class NoteBook {

	// 三相接口
	private ThreePlugIf threePlugIf;

	// 构造方法
	public NoteBook(ThreePlugIf threePlugIf) {
		// TODO Auto-generated constructor stub

		this.threePlugIf = threePlugIf;
	}

	/**
	 * 使用三相插座充电
	 */
	public void charge() {
		threePlugIf.powerWithThree();
	}

	public static void main(String[] args) {

		// 采用组合方式
//		 ooMethod();

		// 采用继承方式的插座适配器
		extendsMethod();
	}

	/**
	 * 采用组合方式的插座适配器
	 */
	public static void ooMethod() {

		// 组合方式
		GBTwoPlug gbTwoPlug = new GBTwoPlug();
		// GBTwoPlugAdapter : 适配器 : 二相转三相
		ThreePlugIf threePlugIf = new GBTwoPlugAdapter(gbTwoPlug);

		NoteBook noteBook = new NoteBook(threePlugIf);
		noteBook.charge();
		/**
		    通过转换 - 二相转三相的插座适配器 
		    使用二相电流供电
		 */
	}

	/**
	 * 采用继承方式的插座适配器
	 */
	public static void extendsMethod() {

		// 继承方式
		ThreePlugIf threePlugIf = new GBTwoPlugAdapterExtends();

		NoteBook noteBook = new NoteBook(threePlugIf);
		noteBook.charge();
		// 2个插头的用3个插头的插座, 执行2个插口的供电方法 : GBTwoPlug的powerWithTwo()方法
		/**
		    采用继承方式的插座适配器 
		    使用二相电流供电
		 */
	}

}
