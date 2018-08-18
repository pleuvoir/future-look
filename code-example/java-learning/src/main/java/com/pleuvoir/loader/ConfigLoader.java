package com.pleuvoir.loader;

import com.pleuvoir.config.XmlConfig;

/**
 * @author pleuvoir
 * 创建时间: 2017年5月5日 下午10:39:14
 */
public interface ConfigLoader {
	
	/**
	 * 设置文件位置  路径可以按照spring的资源配置写法，例如：classpath:xx/xxx.xml
	 * @param location
	 */
	void setLocation(String location);
	

	void load();
	
	/**
	 * 获取加载完成后的配置
	 * @return
	 */
	XmlConfig get();
}
