package com.demo.spring.util;

import org.springframework.context.ApplicationContext;

/** 
* @ClassName: SpringContextUtil 
* @Description: 上下文获取工具类
* @author xuechen
* @date 2017年1月3日 下午5:35:50 
*  
*/
public class SpringContextUtil {

	private static ApplicationContext applicationContext;

	/**
	 * @param applicationContext the applicationContext to set
	 */
	public static void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}
	
	public static Object getBean(String beanId) {
	    return applicationContext.getBean(beanId);
	}
	
	
}
