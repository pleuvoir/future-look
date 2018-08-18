package com.pleuvoir.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**@author pleuvoir
 * 创建时间: 2017年5月5日 下午11:18:13
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CacheConfig {

	@XmlElement(name="persist")
	private Boolean persist;

	@XmlElement(name="location")
	private String location;

	/**
	 * 缓存持久化文件路径
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * 是否需要持久化
	 * @return
	 */
	public boolean isPersist(){
		if(persist==null)
			return false;
		return persist;
	}
}
