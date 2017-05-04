package com.pleuvoir.loader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pleuvoir.RootAppConfig;

/**@author pleuvoir
 * 创建时间: 2017年5月4日 下午9:50:32
 */

public class Bootstrap {

	private Bootstrap(){}

	private static class LoaderHelper {
		
		private static final AnnotationConfigApplicationContext CONTEXT;

		static {
			CONTEXT = initContext();
		}
		
		// 初始化spring容器
		private static AnnotationConfigApplicationContext initContext() {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootAppConfig.class);
			context.registerShutdownHook();
			return context;
		}
	}
	
	/**
	 * 获取spring容器
	 * @return
	 */
	public static AnnotationConfigApplicationContext getApplicationContext(){
		return LoaderHelper.CONTEXT;
	}
	
	/**
	 * 获取spring中的bean
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz){
		return LoaderHelper.CONTEXT.getBean(clazz);
	}
	
	/**
	 * 获取spring中的bean
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName){
		return LoaderHelper.CONTEXT.getBean(beanName);
	}
	
}
