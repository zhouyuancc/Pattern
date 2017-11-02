package com.zy.jdkProxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;


public class MyProxy {
	
	private static File myFile;

	public static Object newProxyInstance(Class myInterface, MyInvocationHandler handler) throws NoSuchMethodException, Exception {

		 // 1. 声明一段源码(动态生成代理)
		dynamicCreateJavaFile(myInterface, handler);
		
		// 2. 编译源码(JDK Compliler API), 产生新的类(代理类)
		Object object = complilerClass(myInterface, handler);
		if (object != null) {
			return object;
		} 
	
		return null;
	}
	
	/**
	 * 2. 编译源码(JDK Compliler API), 产生新的类(代理类)
	 * @throws Exception 
	 * @throws NoSuchMethodException 
	 */
	public static Object complilerClass(Class myInterface, MyInvocationHandler handler) throws NoSuchMethodException, Exception {
		
		// 获取当前系统的编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		
		// 创建文件管理者
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		
		// 获取文件
		Iterable units = fileManager.getJavaFileObjects(myFile);
		
		// 编译任务
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);

		// 进行编译
		task.call();
		fileManager.close();
		
		// 编译成功 : 产生.class文件
		
		// 3. 将这个类load到内存中,产生一个新的对象(代理对象) 
		// load到内存
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		Class<?> class1 = classLoader.loadClass("com.zy.jdkProxy.$Proxy0");
		System.out.println(class1.getName());

		Constructor<?> constructor = class1.getConstructor(MyInvocationHandler.class);
		
		// 4. return 代理对象
		return constructor.newInstance(handler);
	}
	
	
	/**
	 * 1. 声明一段源码(动态生成代理)
	 */
	public static void dynamicCreateJavaFile(Class myInterface, MyInvocationHandler handler) {
		
		String rt = "\r\n";// 换行
		String className = myInterface.getName();

		String methodStr = "";
		// getMethods() : 获取类中所有方法名
		// getName() : 类名
		// .class.getMethod("move") : 获取方法名 | Method md = com.zy.proxy.Moveable.class.getMethod("move");

		for (Method m : myInterface.getMethods()) {

			methodStr += 
					"	@Override" + rt + 
					"  public void " + m.getName() + "() {" + rt +
//					"  h.invoke(); " + rt +
					" 		 try{" + rt +
					"  			 Method md = " + myInterface.getName() + ".class.getMethod(\"" 
												+ m.getName() + "\");" + rt +
					"  			 h.invoke(this,md);" +rt+ 
					"   	 }catch(Exception e){ "+ rt +
					"			 e.printStackTrace();"+ rt +
					"		 }" + rt +
//					+ "		long starttime = System.currentTimeMillis();" + rt
//					+ "		System.out.println(\"start\");" + rt + "		m." + m.getName() + "();" + rt
//					+ "		long endtime = System.currentTimeMillis();" + rt
//					+ "		System.out.println(\"during \" " + rt
//					+ "				+ (endtime - starttime) + \" time\");" + rt 
					"	}";
		}
		
		String str = 
				"package com.zy.jdkProxy;" + rt +
				"import java.lang.reflect.Method;" + rt +
				"import com.zy.jdkProxy.MyInvocationHandler;" + rt + rt +
				"public class $Proxy0 implements " + myInterface.getName() + " {" + rt + rt +
				"	public $Proxy0(MyInvocationHandler h) {" + rt +
				"		super();" + rt +
				"		this.h = h;" + rt +
				"	}" + rt + rt +
//				"  private " + myInterface.getName() + " m;" + rt + rt +
				"  private MyInvocationHandler h; " + rt + rt +
				methodStr + rt +
				"}" ;

		// 本地路径
		String fileName = System.getProperty("user.dir");
		fileName = fileName + "/src/com/zy/jdkProxy/$Proxy0.java";
		// /Users/Zhou/eclipse-workspace/ProxyDesignPattern
		System.out.println(fileName);
		
		File file = new File(fileName);
		myFile = file;

		try {

			FileUtils.writeStringToFile(file, str);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
