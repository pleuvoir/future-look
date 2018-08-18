package com.pleuvoir.plugin;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.springframework.core.io.Resource;

/**
 * <p>@author: pleuvoir</p>
 * <p>@date: 2017年5月6日 下午11:22:39</p>
 * <p>@Description: 基础插件</p>
 */
public interface Plugin {
	
	/**
	 * 加载插件
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	void load() throws Exception;
	
	/**
	 * 设置插件位置
	 * @param location
	 */
	void setLocation(String location);
	
}
