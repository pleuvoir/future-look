package com.pleuvoir.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**@author pleuvoir
 * 创建时间: 2017年5月5日 下午11:27:13
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DbTypeConfig {

	@XmlElement(name="name")
	private String name;

	public String getName() {
		return name;
	}
	
}
