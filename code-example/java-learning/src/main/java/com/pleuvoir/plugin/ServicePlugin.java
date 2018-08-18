package com.pleuvoir.plugin;

/**
 * <p>@author: pleuvoir</p>
 * <p>@date: 2017年5月6日 下午11:29:03</p>
 * <p>@Description: 服务插件</p>
 */
public interface ServicePlugin extends Plugin{

	/**
	 * 获取服务类
	 * @param mode
	 * @return
	 */
	Class<?> getServiceName(String dbType);
}
