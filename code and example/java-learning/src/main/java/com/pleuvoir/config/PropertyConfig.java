package com.pleuvoir.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**@author pleuvoir
 * 属性文件读取
 * 创建时间: 2017年5月4日 下午10:21:34
 */
@Configuration
public class PropertyConfig {

	private String name;

	private String uri;

	@Value("${name}")
	public void setName(String name) {
		this.name = name;
	}

	@Value("${rest.uri}")
	public void setUri(String uri) { 
		if (!uri.endsWith("."))
			uri += ".";
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}

	public String getName() {
		return name;
	}
	
}
