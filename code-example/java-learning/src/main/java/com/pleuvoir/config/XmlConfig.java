package com.pleuvoir.config;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.pleuvoir.common.Json;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;

/**@author pleuvoir
 * 创建时间: 2017年5月5日 下午9:37:45
 */

@XmlRootElement(name="config")   //根节点元素名
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlConfig implements Json{

	@XmlElement(name="mode")
	private String mode;
	
	@XmlElement(name="cache")  //如果出现嵌套 则此处name为 嵌套对象的根节点名
	private CacheConfig cache;
	
	@XmlElementWrapper(name="dbTypes")
	@XmlElement(name="dbType")
	private List<DbTypeConfig> dbTypes;

	public String getMode() {
		return mode;
	}
	
	/**
	 * 缓存配置
	 * @return
	 */
	public CacheConfig getCache(){
		return cache;
	}

	/**
	 * 数据库类型配置
	 * @return
	 */
	public List<DbTypeConfig> getDbTypes() {
		return dbTypes;
	}
	
	
	
}
